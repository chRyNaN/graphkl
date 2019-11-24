package com.chrynan.graphkl.type

data class GraphQLField(
        val name: String,
        val description: String? = null,
        val type: GraphQLOutputType,
        val isDeprecated: Boolean = false,
        val deprecationReason: String? = null,
        val args: List<GraphQLArgument>
)