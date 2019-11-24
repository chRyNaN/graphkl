package com.chrynan.graphkl.type

open class GraphQLScalarType(
        val name: String,
        val description: String? = null
) : GraphQLType,
        GraphQLInputType,
        GraphQLOutputType,
        GraphQLLeafType,
        GraphQLNullableType,
        GraphQLNamedType