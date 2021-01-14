package com.chrynan.graphkl.annotation

/**
 * An annotation for a Kotlin Class or Type Alias that represents a GraphQL Scalar in a GraphQL Query or Schema. For
 * instance, this annotation can be used by code generators, such as annotation processors, for creating a GraphQL DSL
 * based off of introspection from a provided GraphQL Source Document, @see [GraphQLSource]. Note that the annotated
 * class must be a typealias to a primitive or class that can be easily parsed.
 *
 * @property [name] The name of the GraphQL Scalar this Kotlin Class represents. If no value is provided, or the
 * value is blank, the name of the Kotlin Class will be used.
 *
 * Example usage:
 *
 * @GraphQLScalar
 * typealias ID = String
 *
 * @author chRyNaN
 */
@MustBeDocumented
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.TYPEALIAS, AnnotationTarget.CLASS)
annotation class GraphQLScalar(val name: String = "")