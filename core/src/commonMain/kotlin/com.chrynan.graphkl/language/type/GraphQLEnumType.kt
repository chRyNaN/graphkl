package com.chrynan.graphkl.language.type

data class GraphQLEnumType(
        override val name: String,
        val description: String? = null,
        val values: List<GraphQLEnumValue>
) : GraphQLType,
        GraphQLInputType,
        GraphQLOutputType,
        GraphQLLeafType,
        GraphQLNullableType,
        GraphQLNamedType,
        GraphQLTypeNode {

    override val childTypeNodes: List<GraphQLTypeNode> = emptyList()
}