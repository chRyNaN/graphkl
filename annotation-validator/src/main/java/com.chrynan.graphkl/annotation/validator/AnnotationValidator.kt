package com.chrynan.graphkl.annotation.validator

import com.chrynan.graphkl.annotation.*
import javax.annotation.processing.ProcessingEnvironment
import javax.annotation.processing.RoundEnvironment
import javax.lang.model.element.Element
import javax.lang.model.element.ElementKind
import javax.lang.model.element.TypeElement

class AnnotationValidator {

    fun validateAll(
            processingEnvironment: ProcessingEnvironment,
            roundEnvironment: RoundEnvironment
    ): AnnotationValidationResult {
        var scalars = setOf<AnnotatedElementPair<GraphQLScalar>>()
        var enums = setOf<AnnotatedElementPair<GraphQLEnum>>()
        var values = setOf<AnnotatedElementPair<GraphQLValue>>()
        var inputs = setOf<AnnotatedElementPair<GraphQLInput>>()
        var sources = setOf<AnnotatedElementPair<GraphQLSource>>()

        SupportedAnnotation.values()
                .asSequence()
                .associateWith { roundEnvironment.getElementsAnnotatedWith(it.kotlinClass.java) }
                .forEach { (annotation, elements) ->
                    when (annotation) {
                        SupportedAnnotation.GRAPHQL_ENUM -> {
                            enums = validateGraphQLEnum(elements, processingEnvironment)
                        }
                        SupportedAnnotation.GRAPHQL_VALUE -> {
                            values = validateGraphQLValue(elements, processingEnvironment, roundEnvironment)
                        }
                        SupportedAnnotation.GRAPHQL_SOURCE -> {
                            sources = validateGraphQLSource(elements, processingEnvironment, roundEnvironment)
                        }
                        SupportedAnnotation.GRAPHQL_INPUT -> {
                            inputs = validateGraphQLInput(elements, processingEnvironment, roundEnvironment)
                        }
                        SupportedAnnotation.GRAPHQL_SCALAR -> {
                            scalars = validateGraphQLScalar(elements, processingEnvironment, roundEnvironment)
                        }
                    }
                }

        return AnnotationValidationResult(
                scalars = scalars,
                enums = enums,
                values = values,
                inputs = inputs,
                sources = sources)
    }

    private fun validateGraphQLEnum(elements: Set<Element>, processingEnvironment: ProcessingEnvironment): Set<AnnotatedElementPair<GraphQLEnum>> =
            elements.mapNotNull {
                if (it.kind != ElementKind.ENUM) {
                    throw InvalidAnnotatedElementException(
                            expectedKind = ElementKind.ENUM,
                            actualKind = it.kind,
                            element = it,
                            annotationClass = GraphQLEnum::class)
                }

                val annotation: GraphQLEnum? = it.getAnnotation(GraphQLEnum::class.java)

                if (annotation != null) {
                    val element = AnnotatedSourceElement.Class(
                            sourceType = SourceType.SourceClass(
                                    element = it as TypeElement,
                                    elementUtils = processingEnvironment.elementUtils))

                    AnnotatedElementPair(
                            annotation = annotation,
                            element = element)
                } else {
                    null
                }
            }.toSet()

    private fun validateGraphQLInput(elements: Set<Element>, processingEnvironment: ProcessingEnvironment, roundEnvironment: RoundEnvironment): Set<AnnotatedElementPair<GraphQLInput>> {

        return emptySet()
    }

    private fun validateGraphQLScalar(elements: Set<Element>, processingEnvironment: ProcessingEnvironment, roundEnvironment: RoundEnvironment): Set<AnnotatedElementPair<GraphQLScalar>> {

        return emptySet()
    }

    private fun validateGraphQLSource(elements: Set<Element>, processingEnvironment: ProcessingEnvironment, roundEnvironment: RoundEnvironment): Set<AnnotatedElementPair<GraphQLSource>> {

        return emptySet()
    }

    private fun validateGraphQLValue(elements: Set<Element>, processingEnvironment: ProcessingEnvironment, roundEnvironment: RoundEnvironment): Set<AnnotatedElementPair<GraphQLValue>> {

        return emptySet()
    }
}