package com.chrynan.graphkl.dsl.schema

import com.chrynan.graphkl.language.type.GraphQLInterfaceType

class GraphQLInterfaceListBuilder internal constructor() {

    private val interfaces = arrayListOf<GraphQLInterfaceType>()

    fun int(builder: GraphQLInterfaceBuilder.() -> Unit) {
        val interfaceBuilder = GraphQLInterfaceBuilder()
        builder.invoke(interfaceBuilder)
        this.interfaces.add(interfaceBuilder.build())
    }

    internal fun build(): List<GraphQLInterfaceType> = interfaces
}