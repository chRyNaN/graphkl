package com.chrynan.graphkl.query.template

import com.chrynan.graphkl.query.model.QueryRootObjectBuilderClass

class QueryRootObjectBuilderClassTemplate(private val fieldTemplate: QueryFieldDefinitionTemplate = QueryFieldDefinitionTemplate()) : Template<QueryRootObjectBuilderClass> {

    override fun invoke(model: QueryRootObjectBuilderClass) = buildString {
        append("class ${model.name}(private val ${model.builderParameter.name}: ${model.builderParameter.type}) {\n\n")

        val fields = model.fields.joinToString(separator = "\n\n") { fieldTemplate.invoke(it) }

        append(fields)

        append("\n}")
    }
}