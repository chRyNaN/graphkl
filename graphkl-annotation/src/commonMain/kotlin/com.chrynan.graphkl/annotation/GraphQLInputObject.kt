@file:Suppress("unused")

package com.chrynan.graphkl.annotation

/**
 * An annotation for a Kotlin Class that represents a GraphQL Input Object from a GraphQL Query or Schema. For
 * instance, this annotation can be used by code generators, such as annotation processors, for creating a GraphQL DSL
 * based off of introspection from a provided GraphQL Source Document, @see [GraphQLSource]. Note that the annotated
 * class must only contain properties that are primitives, types annotated with [GraphQLScalar], enums annotated with
 * [GraphQLEnum], or other classes annotated with [GraphQLInputObject].
 *
 * @property [name] The name of the GraphQL Input Object this Kotlin Enum Class represents. If no value is provided,
 * or the value is blank, the name of the Kotlin Class will be used.
 *
 * Example usage:
 *
 * @GraphQLInput
 * data class ReviewInput(
 *     val stars: Int,
 *     val commentary: String
 * )
 *
 * @author chRyNaN
 */
@MustBeDocumented
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS, AnnotationTarget.CONSTRUCTOR)
annotation class GraphQLInputObject(val name: String = "")
