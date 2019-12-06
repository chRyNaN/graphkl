package com.chrynan.graphkl.language.type

open class GraphQLScalarType(
        override val name: String,
        val description: String? = null
) : GraphQLType,
        GraphQLInputType,
        GraphQLOutputType,
        GraphQLLeafType,
        GraphQLNullableType,
        GraphQLNamedType,
        GraphQLTypeNode {

    override val childTypeNodes: List<GraphQLTypeNode> = emptyList()
}