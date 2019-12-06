package com.chrynan.graphkl.language.type

data class GraphQLObjectType(
        override val name: String,
        val description: String? = null,
        val fields: List<GraphQLField>,
        val interfaces: List<GraphQLInterfaceType> = emptyList()
) : GraphQLType,
        GraphQLOutputType,
        GraphQLCompositeType,
        GraphQLNullableType,
        GraphQLNamedType,
        GraphQLTypeNode {

    override val childTypeNodes: List<GraphQLTypeNode> =
            interfaces +
                    fields.map { it.type } +
                    fields.flatMap { field -> field.arguments.map { arg -> arg.type } }
}