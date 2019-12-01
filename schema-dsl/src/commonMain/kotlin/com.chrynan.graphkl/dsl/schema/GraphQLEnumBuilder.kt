package com.chrynan.graphkl.dsl.schema

import com.chrynan.graphkl.language.type.GraphQLEnumType
import com.chrynan.graphkl.language.type.GraphQLEnumValue

class GraphQLEnumBuilder internal constructor(initialName: String? = null) {

    var name: String? = initialName
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
                    name = name!!,
                    description = description,
                    values = values)
}

fun enum(name: String? = null, builder: GraphQLEnumBuilder.() -> Unit): GraphQLEnumType {
    val enumBuilder = GraphQLEnumBuilder()
    builder.invoke(enumBuilder)
    return enumBuilder.build()
}