package com.chrynan.graphkl.type

data class GraphQLNonNull(
        val ofType: GraphQLNullableType
) : GraphQLType,
        GraphQLInputType,
        GraphQLOutputType,
        GraphQLWrappingType