package com.chrynan.graphkl.annotation.validator

import javax.annotation.processing.AbstractProcessor
import javax.annotation.processing.RoundEnvironment
import javax.lang.model.element.TypeElement

class TestAnnotationProcessor : AbstractProcessor() {

    override fun process(annotations: MutableSet<out TypeElement>, roundEnv: RoundEnvironment): Boolean {
        val elements = roundEnv.getElementsAnnotatedWith(annotations.first())

        elements.forEach {
            it.annotationMirrors.forEach { }
        }

        return false
    }
}