package com.chrynan.graphkl.schema

import com.chrynan.graphkl.language.type.schema.GraphQLSchema

fun GraphQLSchema.toSchemaString(): String {
    val create = SchemaCreator()

    return create(this)
}