package com.chrynan.graphkl.dsl.schema

import com.chrynan.graphkl.language.type.GraphQLInputField
import com.chrynan.graphkl.language.type.GraphQLInputObjectType

/**
 * A DSL builder class for creating a [GraphQLInputObjectType]. Instead of directly instantiating a
 * [GraphQLInputObjectType], this class can be used, via the [inputObject] function, to create an instance in a Kotlin
 * DSL manner.
 */
class GraphQLInputObjectBuilder internal constructor(private val initialName: String? = null) {

    lateinit var name: String
    var description: String? = null

    private val fields = mutableListOf<GraphQLInputField>()

    fun fields(vararg fields: GraphQLInputField) {
        this.fields.clear()
        this.fields.addAll(fields)
    }

    fun fields(fields: Collection<GraphQLInputField>) {
        this.fields.clear()
        this.fields.addAll(fields)
    }

    fun fields(builder: GraphQLInputFieldListBuilder.() -> Unit) {
        this.fields.clear()
        val fieldListBuilder = GraphQLInputFieldListBuilder()
        builder.invoke(fieldListBuilder)
        this.fields.addAll(fieldListBuilder.build())
    }

    internal fun build(): GraphQLInputObjectType =
            GraphQLInputObjectType(
                    name = if (this::name.isInitialized) name else initialName!!,
                    description = description,
                    fields = fields)
}

/**
 * The entry point function for creating a [GraphQLInputObjectType] in a Kotlin DSL manner.
 *
 * @author chRyNaN
 * @param [name] The optional parameter representing the name of the [GraphQLInputObjectType]. If no value is provided,
 * one must be provided in the [builder].
 * @param [builder] The builder used to create the [GraphQLInputObjectType], scoped to [GraphQLInputObjectBuilder].
 * @return [GraphQLInputObjectType]
 */
fun inputObject(name: String? = null, builder: GraphQLInputObjectBuilder.() -> Unit): GraphQLInputObjectType {
    val objectBuilder = GraphQLInputObjectBuilder(initialName = name)
    builder.invoke(objectBuilder)
    return objectBuilder.build()
}