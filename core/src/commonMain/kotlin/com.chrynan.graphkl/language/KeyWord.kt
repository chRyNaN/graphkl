package com.chrynan.graphkl.language

enum class KeyWord(val value: String) {

    IMPLEMENTS(value = "implements"),
    TYPE(value = "type"),
    SCHEMA(value = "schema"),
    QUERY(value = "query"),
    MUTATION(value = "mutation"),
    SUBSCRIPTION(value = "subscription"),
    SCALAR(value = "scalar"),
    ENUM(value = "enum"),
    INTERFACE(value = "interface"),
    UNION(value = "union"),
    INPUT(value = "input"),
    FRAGMENT(value = "fragment"),
    ON(value = "on"),
    SPREAD(value = "..."),
    INCLUDE(value = "@include")
}