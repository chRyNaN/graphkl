package com.chrynan.graphkl.annotation

/**
 * An annotation for a Kotlin File or Class that contains the URI (Universal Resource Identifier) [String] to a GraphQL
 * Source Document. For instance, this annotation could be used by code generators to load and parse a GraphQL Document
 * and generate a corresponding Kotlin Query DSL.
 *
 * @property [location] This URI (Universal Resource Identifier) representing the location of the GraphQL Source
 * Document. Note that this must be a valid URI and cannot be blank. Also Note that different annotation processors may
 * not support all locations (file, web address, etc).
 *
 * Example usage:
 * @file:GraphQLSource(location = "file://location")
 *
 * package com.example
 *
 * // OR
 *
 * @GraphQLSource(location = "file://location")
 * class MyGraphQLSource
 *
 * @author chRyNaN
 */
@MustBeDocumented
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FILE, AnnotationTarget.CLASS)
annotation class GraphQLSource(val location: String)