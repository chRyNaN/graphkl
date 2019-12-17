package com.chrynan.graphkl.query

data class GraphQLQueryDirective(
        val name: String,
        val arguments: List<GraphQLQueryArgument> = emptyList()
)