package com.chrynan.graphkl.language.type

data class GraphQLNonNull(
        val ofType: GraphQLNullableType
) : GraphQLType,
        GraphQLInputType,
        GraphQLOutputType,
        GraphQLWrappingType