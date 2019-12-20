package com.chrynan.graphkl.annotation.validator

import com.chrynan.graphkl.annotation.*

/**
 * A class representing the result of validating all the supported annotations.
 *
 * @see [AnnotationValidator]
 * @see [SupportedAnnotation]
 *
 * @author chRyNaN
 */
data class AnnotationValidationResult(
        val scalars: Set<AnnotatedElementPair<GraphQLScalar>> = emptySet(),
        val enums: Set<AnnotatedElementPair<GraphQLEnum>> = emptySet(),
        val values: Set<AnnotatedElementPair<GraphQLValue>> = emptySet(),
        val inputs: Set<AnnotatedElementPair<GraphQLInput>> = emptySet(),
        val sources: Set<AnnotatedElementPair<GraphQLSource>> = emptySet()
)