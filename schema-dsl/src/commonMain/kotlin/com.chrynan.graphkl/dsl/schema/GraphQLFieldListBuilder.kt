package com.chrynan.graphkl.dsl.schema

import com.chrynan.graphkl.language.type.GraphQLField
import com.chrynan.graphkl.language.type.GraphQLOutputType

/**
 * A DSL builder class for creating a list of [GraphQLField]s in a Kotlin DSL manner.
 */
class GraphQLFieldListBuilder internal constructor() {

    private val fields = mutableListOf<GraphQLField>()

    fun field(name: String, type: GraphQLOutputType) {
        val fieldBuilder = GraphQLFieldBuilder(initialName = name, initialType = type)
        fields.add(fieldBuilder.build())
    }

    fun field(name: String? = null, type: GraphQLOutputType? = null, builder: GraphQLFieldBuilder.() -> Unit) {
        val fieldBuilder = GraphQLFieldBuilder(initialName = name, initialType = type)
        builder.invoke(fieldBuilder)
        fields.add(fieldBuilder.build())
    }

    internal fun build(): List<GraphQLField> = fields
}