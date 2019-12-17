package com.chrynan.graphkl.query

data class GraphQLQuery(
        val queries: Set<GraphQLQueryRootObject>,
        val mutations: Set<GraphQLQueryRootObject> = emptySet(),
        val subscriptions: Set<GraphQLQueryRootObject> = emptySet(),
        val variables: Set<GraphQLQueryVariable> = emptySet()
)