package com.chrynan.graphkl.kotlin

data class File(
        val name: String,
        val packageName: String,
        val definitions: List<SourceDefinition>,
        val functions: List<Function> = emptyList(),
        val properties: List<Property> = emptyList()
) {

    override fun toString() = buildString {
        append("${PackageStatement(packageName)}\n\n")

        val imports = (definitions.flatMap { it.importStatements } +
                functions.flatMap { it.importStatements } +
                properties.flatMap { it.importStatements }).toSet()

        imports.forEach { append("$it\n") }

        append("\n")

        definitions.forEach { append("$it\n\n") }

        properties.forEach { append("$it\n\n") }

        functions.forEach { append("$it\n\n") }
    }
}