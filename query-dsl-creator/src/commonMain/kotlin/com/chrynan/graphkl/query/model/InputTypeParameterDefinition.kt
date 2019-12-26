package com.chrynan.graphkl.query.model

import com.chrynan.graphkl.kotlin.TypeDefinition

/**
 * Represents an input parameter used in a GraphQL Query. This class is used to construct a Kotlin DSL builder for a
 * GraphQL Query based on a Schema. For example, consider a GraphQL Query Field that contains an "id" [String]
 * argument, such as the following:
 *
 * myField(id: String)
 *
 * This class would represent that argument by having it's "name" property be "id", it's "type" property represent the
 * Kotlin [String] type, and it's "defaultValue" property be null. This class doesn't necessarily only apply to
 * arguments but may be useful for other properties and fields as well. Note that this class is used, along with other
 * classes, in constructing Kotlin DSL builders classes represented as [String]s which can then be generated into
 * Kotlin files.
 *
 * @property [name] The name of this parameter.
 * @property [type] The [TypeDefinition] of this parameter.
 * @property [defaultValue] The default value of this parameter.
 * @property [hasDefaultValue] Whether this parameter has a default value. This has to be a different property because
 * merely using null as an indicator of a whether a default value is provided is not enough. This is because null can
 * be a default value itself.
 *
 * @author chRyNaN
 */
data class InputTypeParameterDefinition(
        val name: String,
        val type: TypeDefinition,
        val defaultValue: Any? = null,
        val hasDefaultValue: Boolean = false
) {

    val declaration: String = buildString {
        append("$name: ${type.typeDeclaration}")

        if (hasDefaultValue) {
            append(" = $defaultValue")
        }
    }

    val genericTypeFunctionDeclaration: String = buildString {
        type.genericTypeVariables.forEachIndexed { index, variable ->
            append(variable.genericFunctionTypeDeclaration)

            if (index != type.genericTypeVariables.lastIndex) {
                append(", ")
            }
        }
    }
}