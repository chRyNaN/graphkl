package com.chrynan.graphkl.directive

import com.chrynan.graphkl.type.GraphQLArgument

open class GraphQLDirective(
        val name: String,
        val description: String? = null,
        val locations: List<String>,
        val args: List<GraphQLArgument>,
        val isRepeatable: Boolean
)