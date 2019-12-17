package com.chrynan.graphkl.query

data class GraphQLQueryRootObject(
        val queryType: GraphQLQueryType = GraphQLQueryType.QUERY,
        override val nestedFields: List<GraphQLQueryField>
) : GraphQLQueryRootObjectNode