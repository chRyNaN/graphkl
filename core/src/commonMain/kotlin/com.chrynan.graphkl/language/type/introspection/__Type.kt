package com.chrynan.graphkl.language.type.introspection

import com.chrynan.graphkl.language.type.*
import com.chrynan.graphkl.language.type.scalar.GraphQLBoolean
import com.chrynan.graphkl.language.type.scalar.GraphQLString

// TODO this may cause a recursion problem, I'm not sure how to fix this right now. The solution may be to create a new
// instance of the GraphQLNamedType and just reference the __Type field. Kind of how the Nodes do.
val __Type: GraphQLObjectType by lazy {
    GraphQLObjectType(
            name = "__Type",
            description = """
            The fundamental unit of any GraphQL Schema is the type. There are many kinds of types in GraphQL as 
            represented by the `__TypeKind` enum.\n\nDepending on the kind of a type, certain fields describe 
            information about that type. Scalar types provide no information beyond a name and description, while Enum 
            types provide their values. Object and Interface types provide the fields they describe. Abstract types, 
            Union and Interface, provide the Object types possible at runtime. List and NonNull types compose other 
            types.
        """.trimIndent(),
            fields = listOf(
                    GraphQLField(
                            name = "kind",
                            type = GraphQLNonNull(__TypeKind)),
                    GraphQLField(
                            name = "name",
                            type = GraphQLString),
                    GraphQLField(
                            name = "description",
                            type = GraphQLString),
                    GraphQLField(
                            name = "fields",
                            type = GraphQLList(GraphQLNonNull(__Field)),
                            arguments = listOf(GraphQLArgument(
                                    name = "includeDeprecated",
                                    type = GraphQLBoolean,
                                    defaultValue = false))),
                    GraphQLField(
                            name = "interfaces",
                            type = GraphQLList(GraphQLNonNull(__Type))),
                    GraphQLField(
                            name = "possibleTypes",
                            type = GraphQLList(GraphQLNonNull(__Type))),
                    GraphQLField(
                            name = "enumValues",
                            type = GraphQLList(GraphQLNonNull(__EnumValue)),
                            arguments = listOf(GraphQLArgument(
                                    name = "includeDeprecated",
                                    type = GraphQLBoolean,
                                    defaultValue = false))),
                    GraphQLField(
                            name = "inputFields",
                            type = GraphQLList(GraphQLNonNull(__InputValue))),
                    GraphQLField(
                            name = "ofType",
                            type = __Type))
    )
}