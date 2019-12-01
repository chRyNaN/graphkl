package com.chrynan.graphkl.dsl.schema

import com.chrynan.graphkl.language.type.GraphQLInputField
import com.chrynan.graphkl.language.type.GraphQLInputType

class GraphQLInputFieldListBuilder internal constructor() {

    private val fields = mutableListOf<GraphQLInputField>()

    fun field(name: String? = null, type: GraphQLInputType? = null) {
        val fieldBuilder = GraphQLInputFieldBuilder(initialName = name, initialType = type)
        fields.add(fieldBuilder.build())
    }

    fun field(name: String? = null, type: GraphQLInputType? = null, builder: GraphQLInputFieldBuilder.() -> Unit) {
        val fieldBuilder = GraphQLInputFieldBuilder(initialName = name, initialType = type)
        builder.invoke(fieldBuilder)
        fields.add(fieldBuilder.build())
    }

    internal fun build(): List<GraphQLInputField> = fields
}