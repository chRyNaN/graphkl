package com.chrynan.graphkl.query.template

import com.chrynan.graphkl.query.model.QueryInputObject

class QueryInputObjectTemplate : Template<QueryInputObject> {

    override fun invoke(model: QueryInputObject) = buildString {
        append("data class ${model.name}(\n")

        model.properties.forEachIndexed { index, parameter ->
            append("\tval $parameter")

            if (index != model.properties.lastIndex) {
                append(",\n")
            }
        }

        append("\n)")
    }
}