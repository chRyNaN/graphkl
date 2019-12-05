package com.chrynan.graphkl.language.type.introspection

import com.chrynan.graphkl.language.DirectiveLocation
import com.chrynan.graphkl.language.type.GraphQLEnumType
import com.chrynan.graphkl.language.type.GraphQLEnumValue

@Suppress("ObjectPropertyName")
val __DirectiveLocation = GraphQLEnumType(
        name = "__DirectiveLocation",
        description = """
            A Directive can be adjacent to many parts of the GraphQL language, a __DirectiveLocation describes one such 
            possible adjacencies.
        """.trimIndent(),
        values = listOf(
                GraphQLEnumValue(
                        name = DirectiveLocation.QUERY.value,
                        value = DirectiveLocation.QUERY),
                GraphQLEnumValue(
                        name = DirectiveLocation.MUTATION.value,
                        value = DirectiveLocation.MUTATION),
                GraphQLEnumValue(
                        name = DirectiveLocation.SUBSCRIPTION.value,
                        value = DirectiveLocation.SUBSCRIPTION),
                GraphQLEnumValue(
                        name = DirectiveLocation.FIELD.value,
                        value = DirectiveLocation.FIELD),
                GraphQLEnumValue(
                        name = DirectiveLocation.FRAGMENT_DEFINITION.value,
                        value = DirectiveLocation.FRAGMENT_DEFINITION),
                GraphQLEnumValue(
                        name = DirectiveLocation.FRAGMENT_SPREAD.value,
                        value = DirectiveLocation.FRAGMENT_SPREAD),
                GraphQLEnumValue(
                        name = DirectiveLocation.INLINE_FRAGMENT.value,
                        value = DirectiveLocation.INLINE_FRAGMENT),
                GraphQLEnumValue(
                        name = DirectiveLocation.VARIABLE_DEFINITION.value,
                        value = DirectiveLocation.VARIABLE_DEFINITION),
                GraphQLEnumValue(
                        name = DirectiveLocation.SCHEMA.value,
                        value = DirectiveLocation.SCHEMA),
                GraphQLEnumValue(
                        name = DirectiveLocation.OBJECT.value,
                        value = DirectiveLocation.OBJECT),
                GraphQLEnumValue(
                        name = DirectiveLocation.FIELD_DEFINITION.value,
                        value = DirectiveLocation.FIELD_DEFINITION),
                GraphQLEnumValue(
                        name = DirectiveLocation.ARGUMENT_DEFINITION.value,
                        value = DirectiveLocation.ARGUMENT_DEFINITION),
                GraphQLEnumValue(
                        name = DirectiveLocation.INTERFACE.value,
                        value = DirectiveLocation.INTERFACE),
                GraphQLEnumValue(
                        name = DirectiveLocation.UNION.value,
                        value = DirectiveLocation.UNION),
                GraphQLEnumValue(
                        name = DirectiveLocation.ENUM.value,
                        value = DirectiveLocation.ENUM_VALUE),
                GraphQLEnumValue(
                        name = DirectiveLocation.ENUM_VALUE.value,
                        value = DirectiveLocation.ENUM_VALUE),
                GraphQLEnumValue(
                        name = DirectiveLocation.INPUT_OBJECT.value,
                        value = DirectiveLocation.INPUT_OBJECT),
                GraphQLEnumValue(
                        name = DirectiveLocation.INPUT_FIELD_DEFINITION.value,
                        value = DirectiveLocation.INPUT_FIELD_DEFINITION),
                GraphQLEnumValue(
                        name = DirectiveLocation.SCALAR.value,
                        value = DirectiveLocation.SCALAR))
)