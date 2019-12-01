package com.chrynan.graphkl.language.type

data class GraphQLEnumValue(
        val name: String,
        val description: String? = null,
        val value: Any,
        val isDeprecated: Boolean = false,
        val deprecationReason: String? = null
)