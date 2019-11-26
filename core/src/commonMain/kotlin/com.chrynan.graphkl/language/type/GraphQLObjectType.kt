package com.chrynan.graphkl.language.type

data class GraphQLObjectType(
        override val name: String,
        val description: String? = null,
        val fields: List<GraphQLField>,
        val interfaces: List<GraphQLInterfaceType>
) : GraphQLType,
        GraphQLOutputType,
        GraphQLCompositeType,
        GraphQLNullableType,
        GraphQLNamedType