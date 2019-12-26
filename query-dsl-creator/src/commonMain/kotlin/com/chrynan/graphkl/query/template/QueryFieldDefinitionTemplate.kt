package com.chrynan.graphkl.query.template

import com.chrynan.graphkl.query.model.QueryFieldDefinition

class QueryFieldDefinitionTemplate : Template<QueryFieldDefinition> {

    override fun invoke(model: QueryFieldDefinition) =
            when (model) {
                is QueryFieldDefinition.Scalar -> handleScalar(model)
                is QueryFieldDefinition.ScalarWithParameters -> handleScalarWithParameters(model)
                is QueryFieldDefinition.Object -> handleObject(model)
            }

    private fun handleScalar(scalar: QueryFieldDefinition.Scalar): String = buildString {
        append("val ${scalar.name}: Unit\n")
        append("\tget() = ${scalar.parentBuilderPropertyName}.field(name = \"${scalar.name}\")\n\n")
        // Create both a property and a function because the function will have the alias parameter
        append(handleScalarWithParameters(scalar.toScalarWithEmptyParameters()))
    }

    private fun handleScalarWithParameters(scalar: QueryFieldDefinition.ScalarWithParameters): String = buildString {
        append("fun ${scalar.name}(${scalar.aliasParameterName}: String? = null, ")

        scalar.parameters.forEachIndexed { index, parameter ->
            append(parameter)

            if (index != scalar.parameters.lastIndex) {
                append(", ")
            }
        }

        append(") {\n")

        val args = scalar.parameters.joinToString(separator = ", ") { "\"${it.name}\" to ${it.name}" }

        append("\t${scalar.parentBuilderPropertyName}.field(${scalar.name}, ${scalar.aliasParameterName}, $args)")

        append("\n}")
    }

    private fun handleObject(obj: QueryFieldDefinition.Object): String = buildString {
        append("fun ${obj.name}(${obj.aliasParameterName}: String? = null, ")

        obj.parameters.forEachIndexed { index, parameter ->
            append(parameter)

            if (index != obj.parameters.lastIndex) {
                append(", ")
            }
        }

        append(", ${obj.nestedBuilderParameterName}: ${obj.nestedBuilderClassName}.() -> Unit) {\n")

        val args = obj.parameters.joinToString(separator = ", ") { "\"${it.name}\" to ${it.name}" }

        append("\t${obj.parentBuilderPropertyName}.field(${obj.name}, ${obj.aliasParameterName}, $args) {\n")

        append("\t\t${obj.nestedBuilderParameterName}.invoke(${obj.nestedBuilderClassName}(this))\n")

        append("\t}\n")

        append("\n}")
    }
}