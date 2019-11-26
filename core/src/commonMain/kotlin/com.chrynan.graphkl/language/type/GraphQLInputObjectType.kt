package com.chrynan.graphkl.language.type

data class GraphQLInputObjectType(
        val name: String,
        val description: String? = null,
        val fields: List<GraphQLInputField>
) : GraphQLType,
        GraphQLInputType,
        GraphQLNullableType,
        GraphQLNamedType