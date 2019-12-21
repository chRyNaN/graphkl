package com.chrynan.graphkl.query

/**
 * An [Enum] representing the type of GraphQL Query that is being performed. There are only three types of GraphQL
 * Queries: QUERY, MUTATION, and SUBSCRIPTION.
 *
 * @property [queryName] The name of this [GraphQLQueryType] used in GraphQL Queries.
 *
 * @author chRyNaN
 */
enum class GraphQLQueryType(val queryName: String) {

    QUERY(queryName = "query"),
    MUTATION(queryName = "mutation"),
    SUBSCRIPTION(queryName = "subscription")
}