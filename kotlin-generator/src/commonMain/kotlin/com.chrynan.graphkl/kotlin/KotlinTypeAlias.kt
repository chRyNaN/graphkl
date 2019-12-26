package com.chrynan.graphkl.kotlin

class KotlinTypeAlias(
        val name: String,
        val type: KotlinTypeDefinition,
        val genericTypeVariable: KotlinGenericTypeParameterDefinition.Variable? = null
) {

    val importStatements: List<KotlinImportStatement> = type.importStatements + (genericTypeVariable?.importStatements
            ?: emptyList())

    override fun toString() = buildString {
        append("typealias $name")

        if (genericTypeVariable != null) {
            append("<$genericTypeVariable>")
        }

        append(" = $type")
    }
}