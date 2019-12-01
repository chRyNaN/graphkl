package com.chrynan.graphkl.dsl.schema

import com.chrynan.graphkl.language.type.GraphQLArgument
import com.chrynan.graphkl.language.type.GraphQLField
import com.chrynan.graphkl.language.type.GraphQLOutputType

class GraphQLFieldBuilder internal constructor(
        private val initialName: String? = null,
        private val initialType: GraphQLOutputType? = null
) {

    lateinit var name: String
    lateinit var type: GraphQLOutputType
    var description: String? = null
    var isDeprecated: Boolean = false
    var deprecationReason: String? = null

    private val arguments = mutableListOf<GraphQLArgument>()

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
            name = if (this::name.isInitialized) name else initialName!!,
            description = description,
            type = if (this::type.isInitialized) type else initialType!!,
            isDeprecated = isDeprecated,
            deprecationReason = deprecationReason,
            arguments = arguments)
}