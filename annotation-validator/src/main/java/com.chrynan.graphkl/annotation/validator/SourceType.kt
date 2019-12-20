package com.chrynan.graphkl.annotation.validator

import javax.lang.model.element.Element
import javax.lang.model.element.TypeElement
import javax.lang.model.util.Elements
import kotlin.reflect.KClass

/**
 * Represents a class type. This type can represent an already compiled type that is available to this module (ex: a
 * class from a library used in this module), a type that is being processed and is not yet compiled (ex: a class being
 * processed by this annotation processor), or a type that will be created by this annotation processor.
 *
 * Note that implementations of this class are considered equal if their [className] and [packageName] are equal.
 *
 * @property [packageName] The [CharSequence] name of the package this class is in.
 * @property [className] The [String] name of this class.
 *
 * @author chRyNaN
 */
sealed class SourceType {

    abstract val packageName: String
    abstract val className: String

    val fullName: String
        get() = "$packageName.$className"

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is SourceType) return false

        return this.packageName == other.packageName && this.className == other.className
    }

    override fun hashCode() = "$packageName.$className".hashCode()

    override fun toString() = "SourceType: $packageName.$className"

    /**
     * A [SourceType] representing a Class that has already been compiled and has an associated [Class] available. Not
     * all Classes are compiled and available to an Annotation Processor. This represents classes that are already
     * compiled, such as, classes from a library used within this module.
     *
     * @param [javaClass] The [Class] that this [SourceType] represents.
     *
     * @author chRyNaN
     */
    class CompiledClass(
            val javaClass: Class<Any>
    ) : SourceType() {

        /**
         * A convenience constructor for creating an instance of a [CompiledClass] using a [KClass] instead of a
         * [Class].
         *
         * @see [CompiledClass]
         */
        constructor(kotlinClass: KClass<Any>) : this(javaClass = kotlinClass.java)

        override val packageName by lazy { javaClass.`package`.name }
        override val className by lazy { javaClass.simpleName }
    }

    /**
     * A [SourceType] representing a Class by the provided package and class name. This can represent a class that is
     * not compiled yet, is not created yet (ex: will be generated), or even an already compiled class (though
     * [CompiledClass] should be preferred).
     *
     * @author chRyNaN
     */
    class NamedClass(
            override val packageName: String,
            override val className: String
    ) : SourceType()

    /**
     * A [SourceType] representing a Class that has not been compiled yet. Not all classes are compiled and available
     * to an Annotation Processor. This represents classes that are not compiled yet and doesn't have a [Class]
     * associated with it yet. Instead it will have a [TypeElement] associated with it that represents the source file.
     *
     * @property [element] The [Element] this [SourceType] represents.
     * @param [elementUtils] The [Elements] utility class used to get the package name of the provided [Element].
     *
     * @author chRyNaN
     */
    class SourceClass(
            val element: TypeElement,
            elementUtils: Elements
    ) : SourceType() {

        override val packageName by lazy { elementUtils.getPackageOf(element).qualifiedName.toString() }
        override val className by lazy { element.simpleName.toString() }
    }
}