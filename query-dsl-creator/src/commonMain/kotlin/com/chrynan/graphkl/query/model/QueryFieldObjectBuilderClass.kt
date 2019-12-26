package com.chrynan.graphkl.query.model

import com.chrynan.graphkl.kotlin.KotlinParameter

data class QueryFieldObjectBuilderClass(
        val name: String,
        val builderParameter: KotlinParameter,
        val fields: Set<QueryFieldDefinition>
)