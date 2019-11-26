package com.chrynan.graphkl.dsl.schema

import com.chrynan.graphkl.language.type.GraphQLArgument
import com.chrynan.graphkl.language.type.GraphQLField
import com.chrynan.graphkl.language.type.GraphQLOutputType

class GraphQLFieldBuilder internal constructor() {

    lateinit var name: String
    lateinit var type: GraphQLOutputType
    var description: String? = null
    var isDeprecated: Boolean = false
    var deprecationReason: String? = null

    private val arguments = arrayListOf<GraphQLArgument>()

    fun arguments(vararg arguments: GraphQLArgument) {
        this.arguments.clear()
        this.arguments.addAll(arguments)
    }

    fun arguments(arguments: Collection<GraphQLArgument>) {
        this.arguments.clear()
        this.arguments.addAll(arguments)
    }

    fun arguments(builder: GraphQLArgumentListBuilder.() -> Unit) {
        this.arguments.clear()
        val argumentListBuilder = GraphQLArgumentListBuilder()
        builder.invoke(argumentListBuilder)
        this.arguments.addAll(argumentListBuilder.build())
    }

    internal fun build() = GraphQLField(
            name = name,
            description = description,
            type = type,
            isDeprecated = isDeprecated,
            deprecationReason = deprecationReason,
            arguments = arguments)
}