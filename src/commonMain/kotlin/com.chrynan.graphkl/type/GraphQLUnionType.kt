package com.chrynan.graphkl.type

class GraphQLUnionType(
        val name: String,
        val description: String? = null,
        val types: List<GraphQLObjectType>
) : GraphQLType,
        GraphQLOutputType,
        GraphQLCompositeType,
        GraphQLAbstractType,
        GraphQLNullableType,
        GraphQLNamedType