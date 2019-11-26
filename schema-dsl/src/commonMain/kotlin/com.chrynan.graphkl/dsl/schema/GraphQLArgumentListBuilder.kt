package com.chrynan.graphkl.dsl.schema

import com.chrynan.graphkl.language.type.GraphQLArgument

class GraphQLArgumentListBuilder internal constructor() {

    private val arguments = arrayListOf<GraphQLArgument>()

    fun argument(builder: GraphQLArgumentBuilder.() -> Unit) {
        val argumentBuilder = GraphQLArgumentBuilder()
        builder.invoke(argumentBuilder)
        arguments.add(argumentBuilder.build())
    }

    internal fun build(): List<GraphQLArgument> = arguments
}