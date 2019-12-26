package com.chrynan.graphkl.kotlin

data class KotlinFile(
        val name: String,
        val packageName: String,
        val definitions: List<KotlinSourceDefinition> = emptyList(),
        val functions: List<KotlinFunction> = emptyList(),
        val properties: List<KotlinProperty> = emptyList(),
        val typeAliases: List<KotlinTypeAlias> = emptyList()
) {

    override fun toString() = buildString {
        append("${KotlinPackageStatement(packageName)}\n\n")

        val imports = (definitions.flatMap { it.importStatements } +
                functions.flatMap { it.importStatements } +
                properties.flatMap { it.importStatements } +
                typeAliases.flatMap { it.importStatements }).toSet()

        imports.forEach { append("$it\n") }

        append("\n")

        typeAliases.forEach { append("$it\n\n") }

        definitions.forEach { append("$it\n\n") }

        properties.forEach { append("$it\n\n") }

        functions.forEach { append("$it\n\n") }
    }
}