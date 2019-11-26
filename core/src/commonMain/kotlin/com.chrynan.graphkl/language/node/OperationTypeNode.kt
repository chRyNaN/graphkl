package com.chrynan.graphkl.language.node

/**
 * Represents a GraphQL Query's possible operations. The possible operations are 'query', 'mutation', and
 * 'subscription'.
 */
enum class OperationTypeNode(val value: String) {

    QUERY(value = "query"),
    MUTATION(value = "mutation"),
    SUBSCRIPTION(value = "subscription")
}