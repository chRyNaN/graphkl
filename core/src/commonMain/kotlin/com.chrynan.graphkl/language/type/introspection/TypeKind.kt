package com.chrynan.graphkl.language.type.introspection

enum class TypeKind(
        val typeName: String,
        val description: String
) {

    SCALAR(typeName = "SCALAR", description = "Indicates this type is a scalar."),
    OBJECT(typeName = "OBJECT", description = "Indicates this type is an object. `fields` and `interfaces` are valid fields."),
    INTERFACE(typeName = "INTERFACE", description = "Indicates this type is an interface. `fields`, `interfaces`, and `possibleTypes` are valid fields."),
    UNION(typeName = "UNION", description = "Indicates this type is an interface. `fields`, `interfaces`, and `possibleTypes` are valid fields."),
    ENUM(typeName = "ENUM", description = "Indicates this type is an enum. `enumValues` is a valid field."),
    INPUT_OBJECT(typeName = "INPUT_OBJECT", description = "Indicates this type is an input object. `inputFields` is a valid field."),
    LIST(typeName = "LIST", description = "Indicates this type is a list. `ofType` is a valid field."),
    NON_NULL(typeName = "NON_NULL", description = "Indicates this type is a non-null. `ofType` is a valid field.")
}