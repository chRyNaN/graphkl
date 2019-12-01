package com.chrynan.graphkl.dsl.schema

import com.chrynan.graphkl.language.type.GraphQLEnumType
import com.chrynan.graphkl.language.type.GraphQLEnumValue

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

fun enum(name: String? = null, builder: GraphQLEnumBuilder.() -> Unit): GraphQLEnumType {
    val enumBuilder = GraphQLEnumBuilder()
    builder.invoke(enumBuilder)
    return enumBuilder.build()
}