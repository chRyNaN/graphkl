package com.chrynan.graphkl.query.model

import com.chrynan.graphkl.kotlin.KotlinParameter

data class QueryEntryFunction(
        val name: String,
        val scopedClass: String? = null,
        val builderParameter: KotlinParameter
)