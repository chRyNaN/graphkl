package com.chrynan.graphkl.language.type

class GraphQLList(
        val ofType: GraphQLType
) : GraphQLType,
        GraphQLInputType,
        GraphQLOutputType,
        GraphQLWrappingType,
        GraphQLNullableType