package com.chrynan.graphkl.annotation.validator

import javax.lang.model.element.Element
import javax.lang.model.element.TypeElement

/**
 * Represents an [Element] that is annotated. This class doesn't contain information about what annotations are used on
 * this element. This class just has information about the element type that is annotated. Note that this class
 * represents an [Element] meaning the underlying classes and reflection utilities may not be available for it.
 *
 * @property [sourceElement] The source [Element] that is annotated.
 *
 * @author chRyNaN
 */
sealed class AnnotatedSourceElement {

    abstract val sourceElement: Element

    /**
     * A Kotlin file that has a file annotation on it.
     *
     * @property [sourceElement] The [Element], representing a Kotlin File, that is annotated.
     *
     * @author chRyNaN
     */
    data class File(
            override val sourceElement: Element,
            val packageName: String,
            val fileName: String
    ) : AnnotatedSourceElement() {

        val fullName: String
            get() = "$packageName.$fileName"
    }

    /**
     * An [AnnotatedSourceElement] representing a Kotlin class that has an annotation on it. Note that the
     * [AnnotatedSourceElement] is essentially a wrapper around an [Element] and therefore there is no Java [Class]
     * available for processing here.
     *
     * @property [sourceType] A [SourceType.SourceClass] representing the annotated source class type.
     * @property [sourceElement] The [Element], representing a Kotlin Class, that is annotated.
     *
     * @author chRyNaN
     */
    data class Class(val sourceType: SourceType.SourceClass) : AnnotatedSourceElement() {

        override val sourceElement: TypeElement
            get() = sourceType.element
    }

    /**
     * An [AnnotatedSourceElement] representing a Kotlin constructor that has an annotation on it.
     *
     * @property [sourceElement] The [Element], representing a Kotlin Constructor, that is annotated.
     * @property [sourceType] The type this constructor is for.
     * @property [isPrimary] Whether this is a Kotlin primary constructor.
     *
     * @author chRyNaN
     */
    data class Constructor(
            override val sourceElement: Element,
            val sourceType: SourceType,
            val isPrimary: Boolean = false
    ) : AnnotatedSourceElement()

    /**
     * An [AnnotatedSourceElement] representing a Kotlin type alias that has an annotation on it.
     *
     * @property [sourceElement] The [Element], representing a Kotlin Type Alias, that is annotated.
     * @property [name] The type alias name.
     * @property [sourceType] The type that is being type aliased.
     *
     * @author chRyNaN
     */
    data class TypeAlias(
            override val sourceElement: Element,
            val name: String,
            val sourceType: SourceType
    ) : AnnotatedSourceElement()

    /**
     * An [AnnotatedSourceElement] representing a Kotlin Property that has an annotation on it.
     *
     * @property [sourceElement] The [Element], representing a Kotlin Property, that is annotated.
     * @property [name] The name of the property.
     * @property [sourceType] the type of the property.
     *
     * @author chRyNaN
     */
    data class Property(
            override val sourceElement: Element,
            val name: String,
            val sourceType: SourceType
    ) : AnnotatedSourceElement()
}