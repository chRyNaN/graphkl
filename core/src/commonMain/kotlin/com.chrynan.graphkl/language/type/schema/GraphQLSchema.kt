package com.chrynan.graphkl.language.type.schema

import com.chrynan.graphkl.language.type.GraphQLNamedType
import com.chrynan.graphkl.language.type.GraphQLObjectType
import com.chrynan.graphkl.language.type.directive.GraphQLDirective
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
 *
 * The following is the documentation from the GraphQL Javascript Specification for the GraphQLSchema type:
 *
 *
 * Schema Definition
 *
 * A Schema is created by supplying the root types of each type of operation,
 * query and mutation (optional). A schema definition is then supplied to the
 * validator and executor.
 *
 * Example:
 *
 *     const MyAppSchema = new GraphQLSchema({
 *       query: MyAppQueryRootType,
 *       mutation: MyAppMutationRootType,
 *     })
 *
 * Note: When the schema is constructed, by default only the types that are
 * reachable by traversing the root types are included, other types must be
 * explicitly referenced.
 *
 * Example:
 *
 *     const characterInterface = new GraphQLInterfaceType({
 *       name: 'Character',
 *       ...
 *     });
 *
 *     const humanType = new GraphQLObjectType({
 *       name: 'Human',
 *       interfaces: [characterInterface],
 *       ...
 *     });
 *
 *     const droidType = new GraphQLObjectType({
 *       name: 'Droid',
 *       interfaces: [characterInterface],
 *       ...
 *     });
 *
 *     const schema = new GraphQLSchema({
 *       query: new GraphQLObjectType({
 *         name: 'Query',
 *         fields: {
 *           hero: { type: characterInterface, ... },
 *         }
 *       }),
 *       ...
 *       // Since this schema references only the `Character` interface it's
 *       // necessary to explicitly list the types that implement it if
 *       // you want them to be included in the final schema.
 *       types: [humanType, droidType],
 *     })
 *
 * Note: If an array of `directives` are provided to GraphQLSchema, that will be
 * the exact list of directives represented and allowed. If `directives` is not
 * provided then a default set of the specified directives (e.g. @include and
 * @skip) will be used. If you wish to provide *additional* directives to these
 * specified directives, you must explicitly declare them. Example:
 *
 *     const MyAppSchema = new GraphQLSchema({
 *       ...
 *       directives: specifiedDirectives.concat([ myCustomDirective ]),
 *     })
 */
data class GraphQLSchema(
        val queryType: GraphQLObjectType? = null,
        val mutationType: GraphQLObjectType? = null,
        val subscriptionType: GraphQLObjectType? = null,
        val directives: List<GraphQLDirective> = emptyList(),
        private val types: List<GraphQLNamedType> = emptyList()
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