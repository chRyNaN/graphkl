package com.chrynan.graphkl.language.type

data class GraphQLInterfaceType(
        override val name: String,
        val description: String? = null,
        val fields: List<GraphQLField>,
        val interfaces: List<GraphQLInterfaceType>
) : GraphQLType,
        GraphQLOutputType,
        GraphQLCompositeType,
        GraphQLAbstractType,
        GraphQLNullableType,
        GraphQLNamedType