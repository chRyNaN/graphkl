package com.chrynan.graphkl.kotlin

data class KotlinParameter(
        val name: String,
        val type: KotlinTypeDefinition,
        val defaultValue: KotlinDefaultValue
) {

    val importStatements: List<KotlinImportStatement> = type.importStatements

    val genericTypeFunctionDeclaration: String = buildString {
        type.genericTypeVariables.forEachIndexed { index, variable ->
            append(variable.genericFunctionTypeDeclaration)

            if (index != type.genericTypeVariables.lastIndex) {
                append(", ")
            }
        }
    }

    override fun toString() = buildString {
        append("$name: $type")

        if (defaultValue.hasDefaultValue) {
            append(" = ${defaultValue.value}")
        }
    }
}