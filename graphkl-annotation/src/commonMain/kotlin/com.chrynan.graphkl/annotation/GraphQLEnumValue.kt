@file:Suppress("unused")

package com.chrynan.graphkl.annotation

/**
 * An annotation for a Kotlin Enum Property that represents a GraphQL Enum Value in a GraphQL Query or Schema. For
 * instance, this annotation can be used by code generators, such as annotation processors, for creating a GraphQL DSL
 * based off of introspection from a provided GraphQL Source Document, @see [GraphQLSource]. This annotation can be
 * used to change the name of an Enum Property for an Enum Class that is annotated with [GraphQLEnum].
 *
 * @property [name] The name of the GraphQL Enum Value this Kotlin Class represents. If no value is provided, or the
 * value is blank, the name of the Kotlin Class will be used.
 *
 * Example usage:
 *
 * @GraphQLEnum
 * enum class Episode {
 *     @GraphQLValue(name = "NEWHOPE") NEW_HOPE,
 *     EMPIRE,
 *     JEDI
 * }
 *
 * @author chRyNaN
 */
@MustBeDocumented
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.PROPERTY)
annotation class GraphQLEnumValue(val name: String = "")
