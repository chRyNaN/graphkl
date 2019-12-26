@file:Suppress("unused")

package com.chrynan.graphkl.query

/**
 * Represents a variable definition in a GraphQL Query.
 *
 * Example:
 *
 * query HeroNameAndFriends($episode: Episode = JEDI)
 *
 * @property [name] The name of the GraphQL Variable. A '$' character will be appended to this value, when outputting
 * the String representation of this variable, if one isn't already provided.
 * @property [typeName] The name of the GraphQL type of this variable.
 * @property [defaultValue] The default value used if no value is provided for this variable. Note that the [toString]
 * function for this value should correctly resolve to a [String] representation of the value.
 *
 * @author chRyNaN
 */
data class GraphQLQueryVariableDefinition(
        val name: String,
        val typeName: String,
        val defaultValue: Any? = null
) {

    /**
     * Returns the [name] property without the GraphQL Variable prefix ('$').
     */
    val nameWithoutPrefix: String
        get() = name.removePrefix("$")

    /**
     * Returns the [name] property with the GraphQL Variable prefix ('$').
     */
    val nameWithPrefix: String
        get() = if (name.startsWith("$")) name else "\$$name"

    override fun toString() = buildString {
        append("$nameWithPrefix: $typeName")

        if (defaultValue != null) {
            append(" = $defaultValue")
        }
    }
}