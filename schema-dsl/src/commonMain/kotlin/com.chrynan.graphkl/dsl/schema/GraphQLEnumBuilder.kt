package com.chrynan.graphkl.dsl.schema

import com.chrynan.graphkl.language.type.GraphQLEnumType
import com.chrynan.graphkl.language.type.GraphQLEnumValue

/**
 * A DSL builder class for creating a [GraphQLEnumType]. Instead of directly instantiating a [GraphQLEnumType], this
 * class can be used, via the [enum] function, to create an instance in a Kotlin DSL manner.
 */
class GraphQLEnumBuilder internal constructor(private val initialName: String? = null) {

    lateinit var name: String
    var description: String? = null

    private val values = mutableListOf<GraphQLEnumValue>()

    operator fun GraphQLEnumValue.unaryPlus() {
        values.add(this)
    }

    operator fun String.unaryPlus() {
        values.add(GraphQLEnumValue(name = this, value = this))
    }

    internal fun build(): GraphQLEnumType =
            GraphQLEnumType(
                    name = if (this::name.isInitialized) name else initialName!!,
                    description = description,
                    values = values)
}

/**
 * The entry point function for creating a [GraphQLEnumType] in a Kotlin DSL manner.
 *
 * @author chRyNaN
 * @param [name] The optional parameter representing the name of the [GraphQLEnumType]. If no value is provided, one
 * must be provided in the [builder].
 * @param [builder] The builder used to create the [GraphQLEnumType], scoped to [GraphQLEnumBuilder].
 * @return [GraphQLEnumType]
 */
fun enum(name: String? = null, builder: GraphQLEnumBuilder.() -> Unit): GraphQLEnumType {
    val enumBuilder = GraphQLEnumBuilder()
    builder.invoke(enumBuilder)
    return enumBuilder.build()
}