package com.chrynan.graphkl.language.type

data class GraphQLList(
        val ofType: GraphQLType
) : GraphQLType,
        GraphQLInputType,
        GraphQLOutputType,
        GraphQLWrappingType,
        GraphQLNullableType