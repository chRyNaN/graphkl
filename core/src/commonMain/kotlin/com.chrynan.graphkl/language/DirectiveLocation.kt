package com.chrynan.graphkl.language

enum class DirectiveLocation(val value: String) {

    QUERY(value = "QUERY"),
    MUTATION(value = "MUTATION"),
    SUBSCRIPTION(value = "SUBSCRIPTION"),
    FIELD(value = "FIELD"),
    FRAGMENT_DEFINITION(value = "FRAGMENT_DEFINITION"),
    FRAGMENT_SPREAD(value = "FRAGMENT_SPREAD"),
    INLINE_FRAGMENT(value = "INLINE_FRAGMENT"),
    VARIABLE_DEFINITION(value = "VARIABLE_DEFINITION"),
    SCHEMA(value = "SCHEMA"),
    SCALAR(value = "SCALAR"),
    OBJECT(value = "OBJECT"),
    FIELD_DEFINITION(value = "FIELD_DEFINITION"),
    ARGUMENT_DEFINITION(value = "ARGUMENT_DEFINITION"),
    INTERFACE(value = "INTERFACE"),
    UNION(value = "UNION"),
    ENUM(value = "ENUM"),
    ENUM_VALUE(value = "ENUM_VALUE"),
    INPUT_OBJECT(value = "INPUT_OBJECT"),
    INPUT_FIELD_DEFINITION(value = "INPUT_FIELD_DEFINITION")
}