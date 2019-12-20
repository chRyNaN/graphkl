package com.chrynan.graphkl.annotation.validator

import javax.lang.model.element.Element
import javax.lang.model.element.ElementKind
import kotlin.reflect.KClass

/**
 * A [RuntimeException] that is thrown when an annotation is provided on an [Element] that it was not supposed to be
 * used on.
 *
 * @param [expectedKind] The [ElementKind] that this annotation was expected to be on.
 * @param [actualKind] The [ElementKind] that the annotation was provided on.
 * @param [element] The [Element] that has the annotation.
 * @param [annotationClass] The [KClass] of the annotation that was on the element.
 *
 * @author chRyNaN
 */
class InvalidAnnotatedElementException(
        expectedKind: ElementKind,
        actualKind: ElementKind,
        element: Element,
        annotationClass: KClass<out Annotation>
) : RuntimeException("Invalid Annotated Element. Annotation $annotationClass was expected to be applied to element " +
        "kind $expectedKind but was on element kind $actualKind instead for element $element. \n" +
        "expectedKind = $expectedKind \n" +
        "actualKind = $actualKind \n" +
        "element = $element \n" +
        "annotationClass = $annotationClass")