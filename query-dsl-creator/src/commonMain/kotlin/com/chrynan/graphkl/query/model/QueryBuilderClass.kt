package com.chrynan.graphkl.query.model

data class QueryBuilderClass(
        val packageName: String,
        val className: String,
        val fields: Set<QueryFieldDefinition>
)