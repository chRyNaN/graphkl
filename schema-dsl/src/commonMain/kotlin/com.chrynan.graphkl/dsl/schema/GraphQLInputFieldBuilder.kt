package com.chrynan.graphkl.dsl.schema

import com.chrynan.graphkl.language.type.GraphQLInputField
import com.chrynan.graphkl.language.type.GraphQLInputType

class GraphQLInputFieldBuilder internal constructor() {

    lateinit var name: String
    lateinit var type: GraphQLInputType
    var description: String? = null
    var defaultValue: Any? = null

    internal fun build(): GraphQLInputField =
            GraphQLInputField(
                    name = name,
                    type = type,
                    description = description,
                    defaultValue = defaultValue)
}