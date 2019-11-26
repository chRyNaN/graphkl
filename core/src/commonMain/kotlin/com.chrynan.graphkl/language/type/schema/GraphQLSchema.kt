package com.chrynan.graphkl.language.type.schema

import com.chrynan.graphkl.language.type.GraphQLObjectType

/**
 * An object that represents a GraphQL Schema. A GraphQL Schema is the root level, or query access point, of a GraphQL
 * Type System which is where the GraphQL API is defined. The following is an example of a GraphQL Schema:
 *
 * schema {
 *     query: MyQueryType
 *     mutation: MyMutationType
 *     subscription: MySubscriptionType
 * }
 *
 * This class represents a defined Schema type that is the GraphQL API entry point. This class can then be used to
 * validate an incoming query for instance.
 */
data class GraphQLSchema(
        val queryType: GraphQLObjectType? = null,
        val mutationType: GraphQLObjectType? = null,
        val subscriptionType: GraphQLObjectType? = null
)