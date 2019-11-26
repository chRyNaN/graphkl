package com.chrynan.graphkl.dsl.schema

import com.chrynan.graphkl.language.type.GraphQLField
import com.chrynan.graphkl.language.type.GraphQLInterfaceType

class GraphQLInterfaceBuilder internal constructor() {

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

    fun interfaces(vararg interfaces: GraphQLInterfaceType) {
        this.interfaces.clear()
        this.interfaces.addAll(interfaces)
    }

    fun interfaces(interfaces: Collection<GraphQLInterfaceType>) {
        this.interfaces.clear()
        this.interfaces.addAll(interfaces)
    }

    fun interfaces(builder: GraphQLInterfaceListBuilder.() -> Unit) {
        this.interfaces.clear()
        val interfaceListBuilder = GraphQLInterfaceListBuilder()
        builder.invoke(interfaceListBuilder)
        this.interfaces.addAll(interfaceListBuilder.build())
    }

    internal fun build() =
            GraphQLInterfaceType(
                    name = name,
                    description = description,
                    fields = fields,
                    interfaces = interfaces)
}