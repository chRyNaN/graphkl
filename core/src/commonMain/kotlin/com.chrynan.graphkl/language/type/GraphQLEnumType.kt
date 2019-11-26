package com.chrynan.graphkl.language.type

data class GraphQLEnumType(
        val name: String,
        val description: String? = null,
        val values: List<GraphQLEnumValue>
) : GraphQLType,
        GraphQLInputType,
        GraphQLOutputType,
        GraphQLLeafType,
        GraphQLNullableType,
        GraphQLNamedType