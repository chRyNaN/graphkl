package com.chrynan.graphkl.annotation

/**
 * An annotation for a Kotlin Enum Class that represents a GraphQL Enum used in a GraphQL Query or Schema. For
 * instance, this annotation can be used by code generators, such as annotation processors, for creating a GraphQL DSL
 * based off of introspection from a provided GraphQL Source Document, @see [GraphQLSource].
 *
 * @property [name] The name of the GraphQLEnum this Kotlin Enum Class represents. If no value is provided, or the
 * value is blank, the name of the Kotlin Enum Class will be used.
 *
 * Example usage:
 *
 * @GraphQLEnum
 * enum class Episode {
 *     NEW_HOPE,
 *     EMPIRE,
 *     JEDI
 * }
 *
 * @author chRyNaN
 */
@MustBeDocumented
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS)
annotation class GraphQLEnum(val name: String = "")