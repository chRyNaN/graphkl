package com.chrynan.graphkl.dsl.schema

import com.chrynan.graphkl.language.type.GraphQLArgument
import com.chrynan.graphkl.language.type.GraphQLInputType

class GraphQLArgumentBuilder internal constructor() {

    lateinit var name: String
    lateinit var type: GraphQLInputType
    var description: String? = null
    var defaultValue: Any? = null

    internal fun build() =
            GraphQLArgument(
                    name = name,
                    type = type,
                    description = description,
                    defaultValue = defaultValue)
}