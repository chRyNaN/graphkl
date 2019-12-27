package com.chrynan.graphkl.query.template

import com.chrynan.graphkl.language.type.GraphQLEnumType

class GraphQLEnumTypeTemplate(private val enumValueTemplate: GraphQLEnumValueTemplate = GraphQLEnumValueTemplate()) : Template<GraphQLEnumType> {

    override fun invoke(model: GraphQLEnumType) = buildString {
        append("enum class $ { model.name } {\n\n")

        model.values.forEach { append("\t${enumValueTemplate(it)}\n") }

        append("}")
    }
}