package com.chrynan.graphkl.language.type.introspection

import com.chrynan.graphkl.language.type.GraphQLEnumType
import com.chrynan.graphkl.language.type.GraphQLEnumValue

@Suppress("ObjectPropertyName")
val __TypeKind = GraphQLEnumType(
        name = "__TypeKind",
        description = "An enum describing what kind of type a given '__Type' is.",
        values = listOf(
                GraphQLEnumValue(
                        name = TypeKind.SCALAR.typeName,
                        description = "Indicates this type is a scalar."),
                GraphQLEnumValue(
                        name = TypeKind.OBJECT.typeName,
                        description = "Indicates this type is an object. `fields` and `interfaces` are valid fields."),
                GraphQLEnumValue(
                        name = TypeKind.INTERFACE.typeName,
                        description = "Indicates this type is an interface. `fields`, `interfaces`, and `possibleTypes` are valid fields."),
                GraphQLEnumValue(
                        name = TypeKind.UNION.typeName,
                        description = "Indicates this type is a union. `possibleTypes` is a valid field."),
                GraphQLEnumValue(
                        name = TypeKind.ENUM.typeName,
                        description = "Indicates this type is an enum. `enumValues` is a valid field."),
                GraphQLEnumValue(
                        name = TypeKind.INPUT_OBJECT.typeName,
                        description = "Indicates this type is an input object. `inputFields` is a valid field."),
                GraphQLEnumValue(
                        name = TypeKind.LIST.typeName,
                        description = "Indicates this type is a list. `ofType` is a valid field."),
                GraphQLEnumValue(
                        name = TypeKind.NON_NULL.typeName,
                        description = "Indicates this type is a non-null. `ofType` is a valid field."))
)