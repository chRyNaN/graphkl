package com.chrynan.graphkl.annotation.validator

import com.chrynan.graphkl.annotation.*
import kotlin.reflect.KClass

/**
 * An [Enum] that represents all the annotations that the [AnnotationValidator] supports. Each of this Enums values
 * directly correlates to a supported annotation class.
 *
 * @property [kotlinClass] The Kotlin [KClass] of the supported annotation.
 *
 * @author chRyNaN
 */
@Suppress("SpellCheckingInspection")
enum class SupportedAnnotation(val kotlinClass: KClass<out Annotation>) {

    GRAPHQL_ENUM(kotlinClass = GraphQLEnum::class),
    GRAPHQL_INPUT(kotlinClass = GraphQLInput::class),
    GRAPHQL_SCALAR(kotlinClass = GraphQLScalar::class),
    GRAPHQL_SOURCE(kotlinClass = GraphQLSource::class),
    GRAPHQL_VALUE(kotlinClass = GraphQLValue::class)
}