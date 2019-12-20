package com.chrynan.graphkl.annotation.validator

/**
 * A class containing an [AnnotatedSourceElement] and the [Annotation] that is on that element. Note that this doesn't
 * mean that there is only one annotation on the element. This is a result type that is returned as a response to
 * looking for elements annotated with a specific annotation class. So, it's possible that two different
 * [AnnotatedElementPair]s could be returned from from different calls looking for different annotations that have the
 * same [AnnotatedSourceElement].
 *
 * @property [annotation] The [Annotation] instance that the [element] was annotated with.
 * @property [element] The [AnnotatedSourceElement] that had the [annotation] on it.
 *
 * @author chRyNaN
 */
data class AnnotatedElementPair<A : Annotation>(
        val annotation: A,
        val element: AnnotatedSourceElement
)