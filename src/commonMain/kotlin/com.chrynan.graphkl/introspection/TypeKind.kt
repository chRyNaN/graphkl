package com.chrynan.graphkl.introspection

enum class TypeKind(val typeName: String) {

    SCALAR(typeName = "SCALAR"),
    OBJECT(typeName = "OBJECT"),
    INTERFACE(typeName = "INTERFACE"),
    UNION(typeName = "UNION"),
    ENUM(typeName = "ENUM"),
    INPUT_OBJECT(typeName = "INPUT_OBJECT"),
    LIST(typeName = "LIST"),
    NON_NULL(typeName = "NON_NULL")
}