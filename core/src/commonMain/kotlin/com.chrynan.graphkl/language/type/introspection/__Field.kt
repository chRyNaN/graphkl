package com.chrynan.graphkl.language.type.introspection

import com.chrynan.graphkl.language.type.GraphQLField
import com.chrynan.graphkl.language.type.GraphQLList
import com.chrynan.graphkl.language.type.GraphQLNonNull
import com.chrynan.graphkl.language.type.GraphQLObjectType
import com.chrynan.graphkl.language.type.scalar.GraphQLBoolean
import com.chrynan.graphkl.language.type.scalar.GraphQLString

@Suppress("ObjectPropertyName")
val __Field = GraphQLObjectType(
        name = "__Field",
        description = """
            Object and Interface types are described by a list of Fields, each of which has a name, potentially a list 
            of arguments, and a return type.
        """.trimIndent(),
        fields = listOf(
                GraphQLField(
                        name = "name",
                        type = GraphQLNonNull(GraphQLString)),
                GraphQLField(
                        name = "description",
                        type = GraphQLString),
                GraphQLField(
                        name = "args",
                        type = GraphQLNonNull(GraphQLList(GraphQLNonNull(__InputValue)))),
                GraphQLField(
                        name = "type",
                        type = GraphQLNonNull(__Type)),
                GraphQLField(
                        name = "isDeprecated",
                        type = GraphQLNonNull(GraphQLBoolean)),
                GraphQLField(
                        name = "deprecationReason",
                        type = GraphQLString))
)