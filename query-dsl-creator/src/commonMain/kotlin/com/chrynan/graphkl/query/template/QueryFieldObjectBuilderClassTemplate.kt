package com.chrynan.graphkl.query.template

import com.chrynan.graphkl.query.model.QueryFieldObjectBuilderClass

class QueryFieldObjectBuilderClassTemplate(private val fieldTemplate: QueryFieldDefinitionTemplate = QueryFieldDefinitionTemplate()) : Template<QueryFieldObjectBuilderClass> {

    override fun invoke(model: QueryFieldObjectBuilderClass) = buildString {
        append("class ${model.name}(private val ${model.builderParameter.name}: ${model.builderParameter.type}) {\n\n")

        val fields = model.fields.joinToString(separator = "\n\n") { fieldTemplate.invoke(it) }

        append(fields)

        append("\n}")
    }
}