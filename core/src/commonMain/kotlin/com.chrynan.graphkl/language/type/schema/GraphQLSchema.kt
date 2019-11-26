package com.chrynan.graphkl.language.type.schema

import com.chrynan.graphkl.language.type.GraphQLObjectType

data class GraphQLSchema(
        val queryType: GraphQLObjectType? = null,
        val mutationType: GraphQLObjectType? = null,
        val subscriptionType: GraphQLObjectType? = null
)