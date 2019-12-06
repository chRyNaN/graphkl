package com.chrynan.graphkl.language.type

data class GraphQLNonNull(
        val ofType: GraphQLNullableType
) : GraphQLType,
        GraphQLInputType,
        GraphQLOutputType,
        GraphQLWrappingType,
        GraphQLTypeNode {

    override val childTypeNodes: List<GraphQLTypeNode> = listOf(ofType)
}