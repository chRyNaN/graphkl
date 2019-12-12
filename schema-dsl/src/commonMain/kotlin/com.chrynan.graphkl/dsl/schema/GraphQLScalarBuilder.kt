package com.chrynan.graphkl.dsl.schema

import com.chrynan.graphkl.language.type.GraphQLScalarType

/**
 * A convenience function for creating a [GraphQLScalarType] in a more concise way. For instance:
 *
 * val myScalar = GraphQLScalarType(name = "MyScalar")
 *
 * // Or creating the same instance using this function
 * val myScalar = scalar(name = "MyScalar")
 *
 * @author chRyNaN
 * @param [name] The name of the [GraphQLScalarType].
 * @param [description] The optional description of the [GraphQLScalarType].
 * @return [GraphQLScalarType]
 */
fun scalar(name: String, description: String? = null) =
        GraphQLScalarType(name = name, description = description)