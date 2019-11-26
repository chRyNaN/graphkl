package com.chrynan.graphkl.schema

import com.chrynan.graphkl.type.GraphQLObjectType

data class GraphQLSchema(
        val queryType: GraphQLObjectType? = null,
        val mutationType: GraphQLObjectType? = null,
        val subscriptionType: GraphQLObjectType? = null
)