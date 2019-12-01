package com.chrynan.graphkl.language.type

data class GraphQLField(
        val name: String,
        val description: String? = null,
        val type: GraphQLOutputType,
        val isDeprecated: Boolean = false,
        val deprecationReason: String? = null,
        val arguments: List<GraphQLArgument> = emptyList()
)