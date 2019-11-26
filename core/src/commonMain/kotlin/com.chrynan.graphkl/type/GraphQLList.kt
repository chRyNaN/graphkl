package com.chrynan.graphkl.type

class GraphQLList(
        val ofType: GraphQLType
) : GraphQLType,
        GraphQLInputType,
        GraphQLOutputType,
        GraphQLWrappingType,
        GraphQLNullableType