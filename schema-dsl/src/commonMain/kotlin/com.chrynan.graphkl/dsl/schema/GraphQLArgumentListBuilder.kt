package com.chrynan.graphkl.dsl.schema

import com.chrynan.graphkl.language.type.GraphQLArgument
import com.chrynan.graphkl.language.type.GraphQLInputType

class GraphQLArgumentListBuilder internal constructor() {

    private val arguments = mutableListOf<GraphQLArgument>()

    fun argument(name: String? = null, type: GraphQLInputType? = null) {
        val argumentBuilder = GraphQLArgumentBuilder(initialName = name, initialType = type)
        arguments.add(argumentBuilder.build())
    }

    fun argument(name: String? = null, type: GraphQLInputType? = null, builder: GraphQLArgumentBuilder.() -> Unit) {
        val argumentBuilder = GraphQLArgumentBuilder(initialName = name, initialType = type)
        builder.invoke(argumentBuilder)
        arguments.add(argumentBuilder.build())
    }

    internal fun build(): List<GraphQLArgument> = arguments
}