package com.chrynan.graphkl.language.type.schema

import com.chrynan.graphkl.language.type.GraphQLNamedType
import com.chrynan.graphkl.language.type.GraphQLObjectType
import com.chrynan.graphkl.utils.reduceType

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
) {

    /**
     * A [List] containing all the [GraphQLNamedType]s declared within this [GraphQLSchema]. Note that this is lazily
     * initialized and the first time accessing this property could take some time. It's best to call this off the main
     * thread or in a suspending function. The reason it is a property is so that it only has to be evaluated once and
     * can be reused.
     */
    val namedTypes: List<GraphQLNamedType> by lazy { reduceType<GraphQLNamedType>() }

    /**
     * A [Map] containing all the [GraphQLNamedType]s declared within this [GraphQLSchema]. The [GraphQLNamedType]s are
     * associated by the [GraphQLNamedType.name] property in the [Map]. Note that this is lazily initialized and the
     * first time accessing this property could take some time. It's best to call this off the main thread or in a
     * suspending function. The reason it is a property is so that it only has to be evaluated once and can be reused.
     */
    val namedTypeMap: Map<String, GraphQLNamedType> by lazy { namedTypes.associateBy { it.name } }
}