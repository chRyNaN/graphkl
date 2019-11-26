package com.chrynan.graphkl.language.type

data class GraphQLInputField(
        val name: String,
        val description: String? = null,
        val type: GraphQLInputType,
        val defaultValue: Any? = null
)