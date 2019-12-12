package com.chrynan.graphkl.dsl.schema

import com.chrynan.graphkl.language.type.GraphQLObjectType
import com.chrynan.graphkl.language.type.GraphQLUnionType

/**
 * A DSL builder class for creating a [GraphQLUnionType] instance. Instead of directly instantiating a
 * [GraphQLUnionType], this class can be used, via the [union] function, to create an instance in a Kotlin DSL manner.
 */
class GraphQLUnionBuilder internal constructor(private val initialName: String? = null) {

    lateinit var name: String
    var description: String? = null

    private val types = mutableSetOf<GraphQLObjectType>()

    infix fun GraphQLObjectType.or(other: GraphQLObjectType): List<GraphQLObjectType> {
        val list = listOf(this, other)
        types.addAll(list)
        return list
    }

    infix fun List<GraphQLObjectType>.or(other: GraphQLObjectType): List<GraphQLObjectType> {
        val list = this + other
        types.addAll(list)
        return list
    }

    internal fun build(): GraphQLUnionType =
            GraphQLUnionType(
                    name = if (this::name.isInitialized) name else initialName!!,
                    description = description,
                    types = types.toList())
}

/**
 * The entry point function to create a [GraphQLUnionType] in a Kotlin DSL manner.
 *
 * @author chRyNaN
 * @see [GraphQLUnionType]
 * @param [name] The optional name parameter representing the name of the [GraphQLUnionType]. If a value is not
 * provided then one must be provided in the [builder].
 * @param [builder] The builder used to create a [GraphQLUnionType], in the scope of [GraphQLUnionBuilder].
 * @return [GraphQLObjectType].
 */
fun union(name: String? = null, builder: GraphQLUnionBuilder.() -> Unit): GraphQLUnionType {
    val unionBuilder = GraphQLUnionBuilder(initialName = name)
    builder.invoke(unionBuilder)
    return unionBuilder.build()
}