package com.chrynan.graphkl.dsl.schema

import com.chrynan.graphkl.language.type.GraphQLInterfaceType

/**
 * A DSL builder class for creating a list of [GraphQLInterfaceType]s in a Kotlin DSL manner.
 */
class GraphQLInterfaceListBuilder internal constructor() {

    private val interfaces = arrayListOf<GraphQLInterfaceType>()

    /**
     * A function that provides a way to create and add a [GraphQLInterfaceType], in a Kotlin DSL manner, to this
     * [GraphQLInterfaceListBuilder] instance.
     *
     * @author chRyNaN
     * @see [graphQLInterface]
     * @see [GraphQLInterfaceBuilder]
     * @param [name] The optional name parameter representing the name of the [GraphQLInterfaceType]. If a value is not
     * provided, one must be provided in the the [builder].
     * @param [builder] The builder used to create an instance of [GraphQLInterfaceType] which will be added to this
     * [GraphQLInterfaceListBuilder].
     * @return [Unit]
     */
    fun int(name: String? = null, builder: GraphQLInterfaceBuilder.() -> Unit) {
        val interfaceBuilder = GraphQLInterfaceBuilder(initialName = name)
        builder.invoke(interfaceBuilder)
        this.interfaces.add(interfaceBuilder.build())
    }

    /**
     * A function that delegates to the [int] function to declare a [GraphQLInterfaceType] within this list builder.
     * This function and the [int] function perform the same task, which one can be used is up to preference. This
     * function name is more verbose but more specific. The [int] function name is more concise but a bit misleading,
     * but unfortunately the name 'interface' is a keyword in Kotlin and can't be used.
     *
     * @author chRyNaN
     * @see [int]
     */
    fun graphQLInterface(name: String? = null, builder: GraphQLInterfaceBuilder.() -> Unit) = int(name = name, builder = builder)

    internal fun build(): List<GraphQLInterfaceType> = interfaces
}