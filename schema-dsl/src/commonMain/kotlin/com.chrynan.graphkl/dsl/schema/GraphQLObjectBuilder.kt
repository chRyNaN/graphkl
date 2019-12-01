package com.chrynan.graphkl.dsl.schema

import com.chrynan.graphkl.language.type.GraphQLField
import com.chrynan.graphkl.language.type.GraphQLInterfaceType
import com.chrynan.graphkl.language.type.GraphQLObjectType

class GraphQLObjectBuilder internal constructor(private val initialName: String? = null) {

    lateinit var name: String
    var description: String? = null

    private val fields = mutableListOf<GraphQLField>()
    private val interfaces = mutableListOf<GraphQLInterfaceType>()

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
            GraphQLObjectType(
                    name = if (this::name.isInitialized) name else initialName!!,
                    description = description,
                    fields = fields,
                    interfaces = interfaces)
}

fun outputObject(name: String? = null, builder: GraphQLObjectBuilder.() -> Unit): GraphQLObjectType {
    val objectBuilder = GraphQLObjectBuilder(initialName = name)
    builder.invoke(objectBuilder)
    return objectBuilder.build()
}