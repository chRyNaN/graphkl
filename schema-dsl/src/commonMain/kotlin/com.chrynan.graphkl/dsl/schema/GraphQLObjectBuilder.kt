package com.chrynan.graphkl.dsl.schema

import com.chrynan.graphkl.language.type.GraphQLField
import com.chrynan.graphkl.language.type.GraphQLInterfaceType
import com.chrynan.graphkl.language.type.GraphQLObjectType

class GraphQLObjectBuilder internal constructor() {

    lateinit var name: String
    var description: String? = null

    private val fields = arrayListOf<GraphQLField>()
    private val interfaces = arrayListOf<GraphQLInterfaceType>()

    fun fields(vararg fields: GraphQLField) {
        this.fields.clear()
        this.fields.addAll(fields)
    }

    fun fields(fields: Collection<GraphQLField>) {
        this.fields.clear()
        this.fields.addAll(fields)
    }

    fun fields(builder: GraphQLFieldListBuilder.() -> Unit) {
        this.fields.clear()
        val fieldListBuilder = GraphQLFieldListBuilder()
        builder.invoke(fieldListBuilder)
        this.fields.addAll(fieldListBuilder.build())
    }

    internal fun build() =
            GraphQLObjectType(
                    name = name,
                    description = description,
                    fields = fields,
                    interfaces = interfaces)
}