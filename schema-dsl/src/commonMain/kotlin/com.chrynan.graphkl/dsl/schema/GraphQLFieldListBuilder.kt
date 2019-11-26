package com.chrynan.graphkl.dsl.schema

import com.chrynan.graphkl.language.type.GraphQLField

class GraphQLFieldListBuilder internal constructor() {

    private val fields = arrayListOf<GraphQLField>()

    fun field(builder: GraphQLFieldBuilder.() -> Unit) {
        val fieldBuilder = GraphQLFieldBuilder()
        builder.invoke(fieldBuilder)
        fields.add(fieldBuilder.build())
    }

    internal fun build(): List<GraphQLField> = fields
}