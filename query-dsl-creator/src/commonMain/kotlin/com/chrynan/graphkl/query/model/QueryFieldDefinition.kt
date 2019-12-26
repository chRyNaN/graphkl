package com.chrynan.graphkl.query.model

import com.chrynan.graphkl.kotlin.KotlinParameter

sealed class QueryFieldDefinition {

    abstract val name: String
    abstract val aliasParameterName: String
    abstract val parentBuilderPropertyName: String

    data class Scalar(
            override val name: String,
            override val aliasParameterName: String,
            override val parentBuilderPropertyName: String
    ) : QueryFieldDefinition() {

        fun toScalarWithEmptyParameters() = ScalarWithParameters(
                name = name,
                aliasParameterName = aliasParameterName,
                parameters = emptyList(),
                parentBuilderPropertyName = parentBuilderPropertyName)
    }

    data class ScalarWithParameters(
            override val name: String,
            override val aliasParameterName: String,
            override val parentBuilderPropertyName: String,
            val parameters: List<KotlinParameter> = emptyList()
    ) : QueryFieldDefinition()

    data class Object(
            override val name: String,
            override val aliasParameterName: String,
            override val parentBuilderPropertyName: String,
            val parameters: List<KotlinParameter> = emptyList(),
            val nestedBuilderParameterName: String,
            val nestedBuilderClassName: String
    ) : QueryFieldDefinition()
}