package com.chrynan.graphkl.query

/**
 * Represents a variable key-value pair in a GraphQL Query. This class represents the variable name and value that is
 * provided alongside a GraphQL Query request, necessary to perform a Query.
 *
 * Example of variables provided as JSON variable dictionary in a GraphQL Query:
 *
 * {
 *     "episode": "JEDI"
 * }
 *
 * @property [name] The name of the GraphQL Variable. A '$' character will be appended to this value, when outputting
 * the String representation of this variable, if one isn't already provided.
 * @property [value] The value of this GraphQL Variable provided in the Query. Note that the [toString] function for
 * this value should correctly resolve to a [String] representation of the value.
 *
 * @author chRyNaN
 */
data class GraphQLQueryVariable(
        val name: String,
        val value: Any?
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

    override fun toString() = "\"$name\": \"$value\""
}