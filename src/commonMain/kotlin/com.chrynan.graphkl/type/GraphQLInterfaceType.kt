package com.chrynan.graphkl.type

data class GraphQLInterfaceType(
        val name: String,
        val description: String? = null,
        val fields: List<GraphQLField>,
        val interfaces: List<GraphQLInterfaceType>
) : GraphQLType,
        GraphQLOutputType,
        GraphQLCompositeType,
        GraphQLAbstractType,
        GraphQLNullableType,
        GraphQLNamedType