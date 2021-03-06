package com.chrynan.graphkl.language.type

data class GraphQLInputObjectType(
        override val name: String,
        val description: String? = null,
        val fields: List<GraphQLInputField>
) : GraphQLType,
        GraphQLInputType,
        GraphQLNullableType,
        GraphQLNamedType,
        GraphQLTypeNode {

    override val childTypeNodes: List<GraphQLTypeNode> = fields.map { it.type }
}