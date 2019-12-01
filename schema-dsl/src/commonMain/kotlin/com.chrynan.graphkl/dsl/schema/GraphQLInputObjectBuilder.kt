package com.chrynan.graphkl.dsl.schema

import com.chrynan.graphkl.language.type.GraphQLInputField
import com.chrynan.graphkl.language.type.GraphQLInputObjectType

class GraphQLInputObjectBuilder internal constructor(private val initialName: String? = null) {

    lateinit var name: String
    var description: String? = null

    private val fields = mutableListOf<GraphQLInputField>()

    fun fields(vararg fields: GraphQLInputField) {
        this.fields.clear()
        this.fields.addAll(fields)
    }

    fun fields(fields: Collection<GraphQLInputField>) {
        this.fields.clear()
        this.fields.addAll(fields)
    }

    fun fields(builder: GraphQLInputFieldListBuilder.() -> Unit) {
        this.fields.clear()
        val fieldListBuilder = GraphQLInputFieldListBuilder()
        builder.invoke(fieldListBuilder)
        this.fields.addAll(fieldListBuilder.build())
    }

    internal fun build(): GraphQLInputObjectType =
            GraphQLInputObjectType(
                    name = if (this::name.isInitialized) name else initialName!!,
                    description = description,
                    fields = fields)
}

fun inputObject(name: String? = null, builder: GraphQLInputObjectBuilder.() -> Unit): GraphQLInputObjectType {
    val objectBuilder = GraphQLInputObjectBuilder(initialName = name)
    builder.invoke(objectBuilder)
    return objectBuilder.build()
}