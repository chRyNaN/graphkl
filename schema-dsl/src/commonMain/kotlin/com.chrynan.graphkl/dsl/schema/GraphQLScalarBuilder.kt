package com.chrynan.graphkl.dsl.schema

import com.chrynan.graphkl.language.type.GraphQLScalarType

fun scalar(name: String, description: String? = null) =
        GraphQLScalarType(name = name, description = description)