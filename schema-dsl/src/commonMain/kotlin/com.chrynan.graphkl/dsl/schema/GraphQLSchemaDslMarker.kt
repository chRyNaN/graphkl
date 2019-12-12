package com.chrynan.graphkl.dsl.schema

/**
 * A [DslMarker] for scoping the Kotlin DSL. This prevents nesting DSL functions where they shouldn't be nested.
 */
@DslMarker
@Target(AnnotationTarget.CLASS, AnnotationTarget.TYPE, AnnotationTarget.FUNCTION)
annotation class GraphQLSchemaDslMarker