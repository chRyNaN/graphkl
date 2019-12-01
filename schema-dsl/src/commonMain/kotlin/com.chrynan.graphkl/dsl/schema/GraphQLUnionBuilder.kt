package com.chrynan.graphkl.dsl.schema

import com.chrynan.graphkl.language.type.GraphQLObjectType
import com.chrynan.graphkl.language.type.GraphQLUnionType

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

fun union(name: String? = null, builder: GraphQLUnionBuilder.() -> Unit): GraphQLUnionType {
    val unionBuilder = GraphQLUnionBuilder(initialName = name)
    builder.invoke(unionBuilder)
    return unionBuilder.build()
}