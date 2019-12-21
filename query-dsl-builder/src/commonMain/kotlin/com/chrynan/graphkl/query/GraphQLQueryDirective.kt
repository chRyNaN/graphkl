package com.chrynan.graphkl.query

/**
 * Represents a GraphQL Directive in a GraphQL Query.
 *
 * Example:
 *
 * @include(if: $withFriends)
 *
 * @property [name] The name of the GraphQL Directive.
 * @property [arguments] The [GraphQLQueryArgument]s for this Directive.
 *
 * @author chRyNaN
 */
data class GraphQLQueryDirective(
        val name: String,
        val arguments: List<GraphQLQueryArgument> = emptyList()
) {

    /**
     * Returns the [name] property without the GraphQL Directive prefix ('@').
     */
    val nameWithoutPrefix: String
        get() = name.removePrefix("@")

    /**
     * Returns the [name] property with the GraphQL Directive prefix ('@').
     */
    val nameWithPrefix: String
        get() = if (name.startsWith("@")) name else "@$name"

    override fun toString() = buildString {
        append("$nameWithPrefix(")

        arguments.forEachIndexed { index, argument ->
            append(argument.toString())

            if (index != arguments.lastIndex) {
                append(", ")
            }
        }

        append(")")
    }
}

/**
 * A Convenience function for creating a [GraphQLQueryDirective].
 *
 * @param [name] The name of the [GraphQLQueryDirective].
 * @param [args] The arguments of the [GraphQLQueryDirective].
 *
 * @author chRyNaN
 */
fun directive(name: String, vararg args: Pair<String, Any?>) =
        GraphQLQueryDirective(
                name = name,
                arguments = args.map { GraphQLQueryArgument(name = it.first, value = it.second) })

/**
 * A Convenience function for creating a [GraphQLQueryDirective].
 *
 * @param [name] The name of the [GraphQLQueryDirective].
 * @param [args] The arguments of the [GraphQLQueryDirective].
 *
 * @author chRyNaN
 */
fun directive(name: String, args: Map<String, Any?>) =
        GraphQLQueryDirective(
                name = name,
                arguments = args.map { GraphQLQueryArgument(name = it.key, value = it.value) })