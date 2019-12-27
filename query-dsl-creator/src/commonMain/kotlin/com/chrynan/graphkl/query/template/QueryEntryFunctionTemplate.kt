package com.chrynan.graphkl.query.template

import com.chrynan.graphkl.query.model.QueryEntryFunction

class QueryEntryFunctionTemplate : Template<QueryEntryFunction> {

    override fun invoke(model: QueryEntryFunction) = """
        fun ${model.scopedClass
            ?: ""}${model.name}(${model.builderParameter.name}: ${model.builderParameter.type}.() -> Unit) =
            graphQL { ${model.builderParameter.name}.invoke(${model.builderParameter.type}(this)) }
    """.trimIndent()
}