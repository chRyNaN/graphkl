package com.chrynan.graphkl.query.model

import com.chrynan.graphkl.kotlin.KotlinParameter

data class QueryInputObject(
        val name: String,
        val properties: List<KotlinParameter>
)