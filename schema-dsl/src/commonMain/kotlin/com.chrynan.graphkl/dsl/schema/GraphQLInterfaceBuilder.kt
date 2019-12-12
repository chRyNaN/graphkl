package com.chrynan.graphkl.dsl.schema

import com.chrynan.graphkl.language.type.GraphQLField
import com.chrynan.graphkl.language.type.GraphQLInterfaceType

/**
 * A DSL builder class for creating a [GraphQLInterfaceType]. Instead of directly instantiating a
 * [GraphQLInterfaceType], this class can be used, via the [graphQLInterface] function, to create an instance in a
 * Kotlin DSL manner.
 */
class GraphQLInterfaceBuilder internal constructor(private val initialName: String? = null) {

    lateinit var name: String
    var description: String? = null

    private val fields = arrayListOf<GraphQLField>()
    private val interfaces = arrayListOf<GraphQLInterfaceType>()

    /**
     * Adds the provided [GraphQLField]s to the [GraphQLInterfaceType] being built in this [GraphQLInterfaceBuilder]
     * instance.
     *
     * Note: This will clear all existing fields.
     *
     * @author chRyNaN
     * @param [fields] The fields to add to this [GraphQLInterfaceType].
     */
    fun fields(vararg fields: GraphQLField) {
        this.fields.clear()
        this.fields.addAll(fields)
    }

    /**
     * Adds the provided [GraphQLField]s to the [GraphQLInterfaceType] being built in this [GraphQLInterfaceBuilder]
     * instance.
     *
     * Note: This will clear all existing fields.
     *
     * @author chRyNaN
     * @param [fields] The fields to add to this [GraphQLInterfaceType].
     */
    fun fields(fields: Collection<GraphQLField>) {
        this.fields.clear()
        this.fields.addAll(fields)
    }

    /**
     * Adds the provided [GraphQLField]s to the [GraphQLInterfaceType] being built in this [GraphQLInterfaceBuilder]
     * instance.
     *
     * Note: This will clear all existing fields.
     *
     * @author chRyNaN
     * @param [builder] The builder used to create the [GraphQLField]s to add to this [GraphQLInterfaceType], scoped to
     * [GraphQLFieldListBuilder].
     */
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
                    name = if (this::name.isInitialized) name else initialName!!,
                    description = description,
                    fields = fields,
                    interfaces = interfaces)
}

/**
 * The entry point function for creating a [GraphQLInterfaceType] in a Kotlin DSL manner.
 *
 * @author chRyNaN
 * @param [name] The optional parameter representing the name of the [GraphQLInterfaceType]. If a value is not
 * provided, one must be provided in the [builder].
 * @param [builder] The builder used to create a [GraphQLInterfaceType], scoped to [GraphQLInterfaceBuilder].
 * @return [GraphQLInterfaceType]
 */
fun graphQLInterface(name: String? = null, builder: GraphQLInterfaceBuilder.() -> Unit): GraphQLInterfaceType {
    val interfaceBuilder = GraphQLInterfaceBuilder(initialName = name)
    builder.invoke(interfaceBuilder)
    return interfaceBuilder.build()
}