package com.chrynan.graphkl.query

enum class GraphQLQueryType(val queryName: String) {

    QUERY(queryName = "query"),
    MUTATION(queryName = "mutation"),
    SUBSCRIPTION(queryName = "subscription")
}