package com.chrynan.graphkl.query

data class GraphQLQueryVariable(
        val name: String,
        val value: Any?,
        val defaultValue: Any? = null
)