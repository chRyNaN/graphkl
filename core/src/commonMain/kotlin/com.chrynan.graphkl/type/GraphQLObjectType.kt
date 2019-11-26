package com.chrynan.graphkl.type

data class GraphQLObjectType(
        val name: String,
        val description: String? = null,
        val fields: List<GraphQLField>,
        val interfaces: List<GraphQLInterfaceType>
) : GraphQLType,
        GraphQLOutputType,
        GraphQLCompositeType,
        GraphQLNullableType,
        GraphQLNamedType