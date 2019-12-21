package com.chrynan.graphkl.query

/**
 * Represents a complete GraphQL Query that is going to be made.
 *
 * @author chRyNaN
 */
@Suppress("unused", "MemberVisibilityCanBePrivate")
data class GraphQLQuery(
        val queries: Set<GraphQLQueryRootObject>,
        val mutations: Set<GraphQLQueryRootObject> = emptySet(),
        val subscriptions: Set<GraphQLQueryRootObject> = emptySet(),
        val variables: Set<GraphQLQueryVariable> = emptySet(),
        val fragments: Set<GraphQLQueryFragment> = emptySet()
) {

    val operations: List<GraphQLQueryRootObject> = queries.toList() + mutations + subscriptions

    fun toRequestString(): String = buildString {
        operations.forEach { append("${it.toRequestString()} \\n") }

        fragments.forEach { append("${it.toRequestString()} \\n") }
    }

    fun toPrettyString(): String = buildString {
        operations.forEach { append("${it.toPrettyString()}\n") }

        fragments.forEach { append("${it.toPrettyString()}\n") }
    }

    override fun toString() = toPrettyString()
}