package com.chrynan.graphkl.type

data class GraphQLArgument(
        val name: String,
        val description: String? = null,
        val type: GraphQLInputType,
        val defaultValue: Any? = null
)