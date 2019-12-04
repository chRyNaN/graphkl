package com.chrynan.graphkl.validation

import com.chrynan.graphkl.language.node.DocumentNode
import com.chrynan.graphkl.language.type.schema.GraphQLSchema

data class ValidationContext(
        val schema: GraphQLSchema,
        val root: DocumentNode
)