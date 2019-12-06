package com.chrynan.graphkl.language.type

data class GraphQLUnionType(
        override val name: String,
        val description: String? = null,
        val types: List<GraphQLObjectType>
) : GraphQLType,
        GraphQLOutputType,
        GraphQLCompositeType,
        GraphQLAbstractType,
        GraphQLNullableType,
        GraphQLNamedType,
        GraphQLTypeNode {

    override val childTypeNodes: List<GraphQLTypeNode> = types
}