package com.chrynan.graphkl.dsl.schema

import com.chrynan.graphkl.language.type.GraphQLArgument
import com.chrynan.graphkl.language.type.GraphQLField
import com.chrynan.graphkl.language.type.GraphQLOutputType

/**
 * A DSL builder class for creating a [GraphQLField] in a Kotlin DSL manner.
 */
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

    /**
     * Adds the provided [GraphQLArgument]s to the [GraphQLField] being built in this [GraphQLFieldBuilder] instance.
     * Note: This will clear all existing arguments.
     *
     * @author chRyNaN
     * @param [arguments] The arguments to add to this [GraphQLField].
     */
    fun arguments(vararg arguments: GraphQLArgument) {
        this.arguments.clear()
        this.arguments.addAll(arguments)
    }

    /**
     * Adds the provided [GraphQLArgument]s to the [GraphQLField] being built in this [GraphQLFieldBuilder] instance.
     * Note: This will clear all existing arguments.
     *
     * @author chRyNaN
     * @param [arguments] The arguments to add to this [GraphQLField].
     */
    fun arguments(arguments: Collection<GraphQLArgument>) {
        this.arguments.clear()
        this.arguments.addAll(arguments)
    }

    /**
     * Adds the provided [GraphQLArgument]s to the [GraphQLField] being built in this [GraphQLFieldBuilder] instance.
     * Note: This will clear all existing arguments.
     *
     * @author chRyNaN
     * @param [builder] The builder used to create the [GraphQLArgument]s for this [GraphQLField], scoped to
     * [GraphQLArgumentListBuilder].
     */
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