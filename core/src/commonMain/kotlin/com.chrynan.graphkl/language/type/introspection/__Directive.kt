package com.chrynan.graphkl.language.type.introspection

import com.chrynan.graphkl.language.type.GraphQLField
import com.chrynan.graphkl.language.type.GraphQLList
import com.chrynan.graphkl.language.type.GraphQLNonNull
import com.chrynan.graphkl.language.type.GraphQLObjectType
import com.chrynan.graphkl.language.type.scalar.GraphQLString

@Suppress("ObjectPropertyName")
val __Directive = GraphQLObjectType(
        name = "__Directive",
        description = """
            A Directive provides a way to describe alternate runtime execution and type validation behavior in a 
            GraphQL document.\n\nIn some cases, you need to provide options to alter GraphQL's execution behavior in 
            ways field arguments will not suffice, such as conditionally including or skipping a field. Directives 
            provide this by describing additional information to the executor.
        """.trimIndent(),
        fields = listOf(
                GraphQLField(
                        name = "name",
                        type = GraphQLNonNull(GraphQLString)),
                GraphQLField(
                        name = "description",
                        type = GraphQLString),
                GraphQLField(
                        name = "locations",
                        type = GraphQLNonNull(GraphQLList(GraphQLNonNull(__DirectiveLocation)))),
                GraphQLField(
                        name = "args",
                        type = GraphQLNonNull(GraphQLList(GraphQLNonNull(__InputValue)))))
)