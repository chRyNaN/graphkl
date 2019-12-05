package com.chrynan.graphkl.language.type.introspection

import com.chrynan.graphkl.language.type.GraphQLField
import com.chrynan.graphkl.language.type.GraphQLNonNull
import com.chrynan.graphkl.language.type.GraphQLObjectType
import com.chrynan.graphkl.language.type.scalar.GraphQLString

@Suppress("ObjectPropertyName")
val __InputValue = GraphQLObjectType(
        name = "__InputValue",
        description = """
                Arguments provided to Fields or Directives and the input fields of an InputObject are represented as 
                Input Values which describe their type and optionally a default value.
        """.trimIndent(),
        fields = listOf(
                GraphQLField(
                        name = "name",
                        type = GraphQLNonNull(GraphQLString)),
                GraphQLField(
                        name = "description",
                        type = GraphQLString),
                GraphQLField(
                        name = "type",
                        type = GraphQLNonNull(__Type)),
                GraphQLField(
                        name = "defaultValue",
                        type = GraphQLString,
                        description = "A GraphQL-formatted string representing the default value for this input value.")
        )
)