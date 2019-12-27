package com.chrynan.graphkl.query.model

import com.chrynan.graphkl.kotlin.KotlinParameter

data class QueryBuilderClass(
        val name: String,
        val builderParameter: KotlinParameter,
        val operationNameParameterName: String,
        val queryParameter: KotlinParameter,
        val mutationParameter: KotlinParameter,
        val subscriptionParameter: KotlinParameter
)