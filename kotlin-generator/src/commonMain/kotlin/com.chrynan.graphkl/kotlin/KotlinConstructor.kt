package com.chrynan.graphkl.kotlin

import com.chrynan.graphkl.kotlin.modifier.VisibilityModifier

data class KotlinConstructor(
        val isPrimary: Boolean = false,
        val visibility: VisibilityModifier = VisibilityModifier.PUBLIC,
        val parameters: List<KotlinParameter> = emptyList(),
        val constructorCall: ((KotlinConstructor) -> String)? = null,
        val extraImports: List<KotlinImportStatement> = emptyList(),
        val body: ((KotlinConstructor) -> String)? = null
) {

    val importStatements: List<KotlinImportStatement> = parameters.flatMap { it.importStatements } + extraImports

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
            append(": ${constructorCall.invoke(this@KotlinConstructor)}")
        }

        if (body != null) {

            append(" {\n")

            append(body.invoke(this@KotlinConstructor))

            append("\n}")
        }
    }
}