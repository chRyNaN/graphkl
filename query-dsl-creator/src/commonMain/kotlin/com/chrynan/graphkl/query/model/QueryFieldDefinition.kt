package com.chrynan.graphkl.query.model

import com.chrynan.graphkl.kotlin.ImportStatement

data class QueryFieldDefinition(
        val name: String,
        val parameters: List<InputTypeParameterDefinition> = emptyList(),
        val nestedBuilder: QueryBuilderClass? = null
) {

    val isKotlinFunction: Boolean
        get() = parameters.isNotEmpty()

    val isKotlinProperty: Boolean
        get() = !isKotlinFunction

    val declaration: String = buildString {
        if (parameters.isEmpty() && nestedBuilder == null) {
            append("val $name: Unit")
        } else if (parameters.isEmpty()) {
            append("fun $name(builder: ${nestedBuilder?.className}.() -> Unit)")
        } else {
            append("fun ")

            val genericTypeDeclarations = parameters.map { it.genericTypeFunctionDeclaration }

            if (genericTypeDeclarations.isNotEmpty()) {
                append("<")

                genericTypeDeclarations.forEachIndexed { index, s ->
                    append(s)

                    if (index != genericTypeDeclarations.lastIndex) {
                        append(", ")
                    }
                }

                append("> ")
            }

            append("$name(")

            parameters.forEachIndexed { index, definition ->
                append(definition.declaration)

                if (index != parameters.lastIndex) {
                    append(", ")
                }
            }

            if (nestedBuilder != null) {
                append(", builder:  ${nestedBuilder.className}.() -> Unit")
            }

            append(")")
        }
    }

    val importStatements: List<ImportStatement> = parameters.flatMap { it.type.importStatements }
}