package com.chrynan.graphkl.kotlin

import com.chrynan.graphkl.kotlin.modifier.VisibilityModifier

data class Constructor(
        val isPrimary: Boolean = false,
        val visibility: VisibilityModifier = VisibilityModifier.PUBLIC,
        val parameters: List<Parameter> = emptyList(),
        val constructorCall: ((Constructor) -> String)? = null,
        val extraImports: List<ImportStatement> = emptyList(),
        val body: (Constructor) -> String
) {

    val importStatements: List<ImportStatement> = parameters.flatMap { it.importStatements } + extraImports

    override fun toString() = buildString {
        if (!isPrimary) {
            append("constructor")
        }

        append("(")

        parameters.forEachIndexed { index, parameter ->
            append(parameter)

            if (index != parameters.lastIndex) {
                append(", ")
            }
        }

        append(")")

        if (constructorCall != null) {
            append(": ${constructorCall.invoke(this@Constructor)}")
        }

        append(" {\n")

        append(body(this@Constructor))

        append("\n}")
    }
}