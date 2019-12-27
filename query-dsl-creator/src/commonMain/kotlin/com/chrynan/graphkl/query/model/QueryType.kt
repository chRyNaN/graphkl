package com.chrynan.graphkl.query.model

import com.chrynan.graphkl.kotlin.KotlinTypeDefinition
import com.chrynan.graphkl.language.type.GraphQLNamedType

data class QueryType(
        val kotlinType: KotlinTypeDefinition,
        val graphQLType: GraphQLNamedType
)