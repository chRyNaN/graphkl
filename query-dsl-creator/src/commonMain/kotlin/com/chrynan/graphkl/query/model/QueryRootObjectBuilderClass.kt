package com.chrynan.graphkl.query.model

import com.chrynan.graphkl.kotlin.KotlinParameter

data class QueryRootObjectBuilderClass(
        val name: String,
        val builderParameter: KotlinParameter,
        val fields: Set<QueryFieldDefinition>
)