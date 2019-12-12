package com.chrynan.graphkl.dsl.schema

import com.chrynan.graphkl.language.type.GraphQLArgument
import com.chrynan.graphkl.language.type.GraphQLInputType

/**
 * A DSL builder class for creating a [GraphQLArgument] in a Kotlin DSL manner.
 */
class GraphQLArgumentBuilder internal constructor(
        private val initialName: String? = null,
        private val initialType: GraphQLInputType? = null
) {

    lateinit var name: String
    lateinit var type: GraphQLInputType
    var description: String? = null
    var defaultValue: Any? = null

    internal fun build() =
            GraphQLArgument(
                    name = if (this::name.isInitialized) name else initialName!!,
                    type = if (this::type.isInitialized) type else initialType!!,
                    description = description,
                    defaultValue = defaultValue)
}