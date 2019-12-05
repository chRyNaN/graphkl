package com.chrynan.graphkl.language.type.introspection

import com.chrynan.graphkl.language.type.GraphQLField
import com.chrynan.graphkl.language.type.GraphQLList
import com.chrynan.graphkl.language.type.GraphQLNonNull
import com.chrynan.graphkl.language.type.GraphQLObjectType

@Suppress("ObjectPropertyName")
val __Schema = GraphQLObjectType(
        name = "__Schema",
        description = """
            A GraphQL Schema defines the capabilities of a GraphQL server. It exposes all available types and 
            directives on the server, as well as the entry points for query, mutation, and subscription operations.
        """.trimIndent(),
        fields = listOf(
                GraphQLField(
                        name = "types",
                        description = "A list of all types supported by this server.",
                        type = GraphQLNonNull(GraphQLList(GraphQLNonNull(__Type)))),
                GraphQLField(
                        name = "queryType",
                        description = "The type that query operations will be rooted at.",
                        type = GraphQLNonNull(__Type)),
                GraphQLField(
                        name = "mutationType",
                        description = """
                            If this server supports mutation, the type that mutation operations will be rooted at.
                        """.trimIndent(),
                        type = __Type),
                GraphQLField(
                        name = "subscriptionType",
                        description = """
                            If this server support subscription, the type that subscription operations will be rooted 
                            at.
                        """.trimIndent(),
                        type = __Type),
                GraphQLField(
                        name = "directives",
                        description = "A list of all directives supported by this server.",
                        type = GraphQLNonNull(GraphQLList(GraphQLNonNull(__Directive)))))
)