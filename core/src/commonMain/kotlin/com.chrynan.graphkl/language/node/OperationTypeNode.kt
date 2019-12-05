package com.chrynan.graphkl.language.node

/**
 * Represents a GraphQL Query's possible operations. The possible operations are 'query', 'mutation', and
 * 'subscription'.
 *
 * "Operations" are a generic name for requests in the document.
 * Examples of this include:
 * 1) query,
 * 2) mutation
 */
enum class OperationTypeNode(val value: String) {

    QUERY(value = "query"),
    MUTATION(value = "mutation"),
    SUBSCRIPTION(value = "subscription")
}