package com.chrynan.graphkl.query

/**
 * Represents an argument provided in a GraphQL Query. Note: make sure the [value] parameter correctly resolves to a
 * String representation of the value when using the [toString] function.
 *
 * Example:
 *
 * human(id: "1000") {
 *     name
 *     height
 * }
 *
 * @property [name] The name of the GraphQL argument ("id" in the above example).
 * @property [value] The value of the GraphQL argument ("1000" in the above example).
 *
 * @author chRyNaN
 */
data class GraphQLQueryArgument(
        val name: String,
        val value: Any?
) {

    override fun toString() = buildString {
        append("$name: ")

        when (value) {
            is GraphQLQueryVariableDefinition -> append(value.nameWithPrefix)
            is GraphQLQueryVariable -> append(value.nameWithPrefix)
            else -> append(value)
        }
    }
}