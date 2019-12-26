package com.chrynan.graphkl.kotlin

/**
 * Represents a Kotlin Generic Type Definition. This can be a generic type variable (ex: T), a generic type variable
 * that extends another class (ex: T : String), or a specific type used in a generic type parameter (ex: String).
 *
 * @author chRyNaN
 */
sealed class GenericTypeParameterDefinition {

    /**
     * Example:
     *
     * T : SomeType
     *
     * to be used in a function generic type declaration like so:
     *
     * fun <T : SomeType>
     *
     * @author chRyNaN
     */
    abstract val genericFunctionTypeDeclaration: String?

    /**
     * Example:
     *
     * T
     *
     * Example:
     *
     * String
     *
     * Example:
     *
     * List<String>
     *
     * @author chRyNaN
     */
    abstract val typeDeclaration: String

    /**
     * All import statements for the types used in this generic type.
     *
     * @author chRyNaN
     */
    abstract val importStatements: List<ImportStatement>

    data class Variable(
            val name: String,
            val extends: GenericTypeParameterDefinition? = null
    ) : GenericTypeParameterDefinition() {

        override val genericFunctionTypeDeclaration: String = buildString {
            append(name)

            if (extends != null) {
                append(" : ${extends.typeDeclaration}")
            }
        }

        override val typeDeclaration = name

        override val importStatements: List<ImportStatement> = extends?.importStatements ?: emptyList()
    }

    data class Type(val typeDefinition: TypeDefinition) : GenericTypeParameterDefinition() {

        override val genericFunctionTypeDeclaration: String? = null

        override val typeDeclaration = typeDefinition.typeDeclaration

        override val importStatements: List<ImportStatement> = typeDefinition.importStatements
    }
}