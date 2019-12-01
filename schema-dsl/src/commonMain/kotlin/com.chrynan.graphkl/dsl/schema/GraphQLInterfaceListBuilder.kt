package com.chrynan.graphkl.dsl.schema

import com.chrynan.graphkl.language.type.GraphQLInterfaceType

class GraphQLInterfaceListBuilder internal constructor() {

    private val interfaces = arrayListOf<GraphQLInterfaceType>()

    fun int(name: String? = null, builder: GraphQLInterfaceBuilder.() -> Unit) {
        val interfaceBuilder = GraphQLInterfaceBuilder(initialName = name)
        builder.invoke(interfaceBuilder)
        this.interfaces.add(interfaceBuilder.build())
    }

    internal fun build(): List<GraphQLInterfaceType> = interfaces
}