package com.chrynan.graphkl.query

data class GraphQLQueryField(
        val name: String,
        val arguments: List<GraphQLQueryArgument> = emptyList(),
        val directives: List<GraphQLQueryDirective> = emptyList(),
        override val nestedFields: List<GraphQLQueryField> = emptyList()
) : GraphQLQueryFieldNode