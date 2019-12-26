package com.chrynan.graphkl.kotlin

import com.chrynan.graphkl.kotlin.modifier.FunctionModifier
import com.chrynan.graphkl.kotlin.modifier.VisibilityModifier

class Function(
        val name: String,
        val returnType: TypeDefinition = UNIT_TYPE_DEFINITION,
        val visibility: VisibilityModifier = VisibilityModifier.PUBLIC,
        val modifiers: Set<FunctionModifier> = emptySet(),
        val parameters: List<Parameter> = emptyList(),
        val extraImports: List<ImportStatement> = emptyList(),
        val body: (Function) -> String
) {

    val importStatements: List<ImportStatement> = returnType.importStatements + parameters.flatMap { it.importStatements } + extraImports

    override fun toString() = buildString {
        append("${visibility.keyword.value} ")

        modifiers.forEach { append("${it.keyword.value} ") }

        append("fun ")

        val genericTypeVariables = parameters.map { it.type.genericTypeVariables }

        if (genericTypeVariables.isNotEmpty()) {
            append("<")

            genericTypeVariables.forEachIndexed { index, variable ->
                append(variable)

                if (index != genericTypeVariables.lastIndex) {
                    append(", ")
                }
            }

            append("> ")
        }

        append("$name(")

        parameters.forEachIndexed { index, parameter ->
            append(parameter)

            if (index != parameters.lastIndex) {
                append(", ")
            }
        }

        append("): $returnType {\n")

        append(body(this@Function))

        append("\n}")
    }
}