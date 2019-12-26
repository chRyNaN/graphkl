package com.chrynan.graphkl.kotlin

data class Parameter(
        val name: String,
        val type: TypeDefinition,
        val defaultValue: DefaultValue
) {

    val importStatements: List<ImportStatement> = type.importStatements

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