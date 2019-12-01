package com.chrynan.graphkl.dsl.schema

import com.chrynan.graphkl.language.type.GraphQLInputField

class GraphQLInputFieldListBuilder internal constructor() {

    private val fields = mutableListOf<GraphQLInputField>()

    fun field(builder: GraphQLInputFieldBuilder.() -> Unit) {
        val fieldBuilder = GraphQLInputFieldBuilder()
        builder.invoke(fieldBuilder)
        fields.add(fieldBuilder.build())
    }

    internal fun build(): List<GraphQLInputField> = fields
}