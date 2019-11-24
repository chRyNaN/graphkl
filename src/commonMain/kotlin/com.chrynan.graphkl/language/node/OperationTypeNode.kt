package com.chrynan.graphkl.language.node

enum class OperationTypeNode(val value: String) {

    QUERY(value = "query"),
    MUTATION(value = "mutation"),
    SUBSCRIPTION(value = "subscription")
}