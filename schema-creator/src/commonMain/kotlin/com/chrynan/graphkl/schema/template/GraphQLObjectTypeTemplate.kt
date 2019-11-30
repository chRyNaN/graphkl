package com.chrynan.graphkl.schema.template

import com.chrynan.graphkl.language.type.GraphQLObjectType

class GraphQLObjectTypeTemplate(private val getField: GraphQLFieldTemplate) {

    operator fun invoke(type: GraphQLObjectType): String = buildString {
        append("type ${type.name}")

        if (type.interfaces.isNotEmpty()) {
            append(" implements ")

            type.interfaces.forEachIndexed { index, int ->
                append(int.name)

                if (index != type.interfaces.size - 1) {
                    append(", ")
                }
            }
        }

        append(" {\n")

        type.fields.forEach {
            append(getField(it))
            append("\n")
        }

        append("}")
    }
}