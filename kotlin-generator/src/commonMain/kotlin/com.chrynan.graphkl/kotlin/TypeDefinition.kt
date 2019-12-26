package com.chrynan.graphkl.kotlin

/**
 * Represents a type that can be used as an input in a GraphQL Query. This class contains type information, such as,
 * the package and class names of the Kotlin type. For example, consider a GraphQL Field that takes in a [String] id as
 * an argument. This class would hold information about the corresponding Kotlin [String] type
 * (ex: packageName = "kotlin", className = "String", etc). This class is used to create a type safe Kotlin DSL for
 * creating GraphQL Queries. The information in this class is necessary to know what types to import and use for each
 * input field. Note that this class does not represent a value inputted but rather the definition of the type that is
 * allowed to be input. Also, this class does not contain information about a property of this type, such as, the name
 * of the property or any default value.
 *
 * @property [packageName] The name of the Kotlin type's package.
 * @property [className] The name of the Kotlin type's class.
 * @property [classImportAliasName] The name of the type alias used for this Kotlin type. If there is no alias, this field
 * should be null. Note that this will be used as an import alias and not a type alias. If you wish to use a type
 * alias, then just provide the [packageName] and [className] of the type alias with this field as null.
 * @property [isNullable] If this Kotlin type is nullable or not.
 * @property [genericTypes] Any generic type parameters on this type. If there are no generic type parameters, then
 * this should be an empty list. For instance, a [String] has no generic type parameters so this field would be an
 * empty list. But for a [List] of [String]s, there would be one generic type parameter of [String]. Likewise, for a
 * [Map] of [String] and [Int], there would be two generic type parameters of [String] and [Int]. Notice how order
 * matters.
 *
 * @author chRyNaN
 */
data class TypeDefinition(
        val packageName: String,
        val className: String,
        val classImportAliasName: String? = null,
        val isNullable: Boolean,
        val genericTypes: List<GenericTypeParameterDefinition> = emptyList()
) {

    /**
     * The import statement [String] of the Kotlin type this [TypeDefinition] represents.
     *
     * Example:
     *
     * import com.chrynan.graphkl.kotlin.InputTypeDefinition as InputType
     *
     * @author chRyNaN
     */
    val importStatement = ImportStatement(fullName = "$packageName.$className", alias = classImportAliasName)

    /**
     * A [String] containing import statements for this [TypeDefinition] and all [TypeDefinition]s of the
     * [genericTypes]. Note that this will be a multi-line [String] if there are [genericTypes]. Otherwise this will be
     * the same as [importStatement].
     *
     * Example:
     *
     * import kotlin.String
     * import kotlin.collections.List
     *
     * @author chRyNaN
     */
    val importStatements: List<ImportStatement> = genericTypes.flatMap { it.importStatements } + importStatement

    /**
     * The Kotlin type declaration that this [TypeDefinition] represents.
     *
     * Example:
     *
     * List<String>?
     *
     * @author
     */
    val typeDeclaration: String = buildString {
        if (classImportAliasName != null) {
            append(classImportAliasName)
        } else {
            append(className)
        }

        if (genericTypes.isNotEmpty()) {
            append("<")

            genericTypes.forEachIndexed { index, type ->
                append(type.typeDeclaration)

                if (index != genericTypes.lastIndex) {
                    append(", ")
                }
            }

            append(">")
        }

        if (isNullable) {
            append("?")
        }
    }

    /**
     * [genericTypes] that are [GenericTypeParameterDefinition.Variable]s. This allows a caller to easily grabbed the
     * filtered list to perform any operations, such as, creating generic type declarations for functions.
     *
     * @author chRyNaN
     */
    val genericTypeVariables: List<GenericTypeParameterDefinition.Variable> =
            genericTypes.filterIsInstance<GenericTypeParameterDefinition.Variable>()
}