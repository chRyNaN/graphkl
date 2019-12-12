package com.chrynan.graphkl.dsl.schema

import com.chrynan.graphkl.language.type.GraphQLList
import com.chrynan.graphkl.language.type.GraphQLNonNull
import com.chrynan.graphkl.language.type.GraphQLNullableType
import com.chrynan.graphkl.language.type.GraphQLType
import com.chrynan.graphkl.language.type.scalar.GraphQLString

/**
 * Retrieves a non-null GraphQL type version of this [GraphQLNullableType] by wrapping it in a [GraphQLNonNull]. This
 * is a convenience function useful for avoiding wrapping objects.
 *
 * @author chRyNaN
 * @see [GraphQLNonNull]
 * @see [GraphQLNullableType]
 * @receiver [GraphQLNullableType] A type that can be null and is nullable by default. Wrapping this type in a
 * [GraphQLNonNull] object will make it non-null.
 * @sample GraphQLString.asNonNull
 */
fun GraphQLNullableType.asNonNull() = GraphQLNonNull(ofType = this)

/**
 * Retrieves a list GraphQL type of this [GraphQLType] by wrapping it in a [GraphQLList]. This is a convenience
 * function useful for avoiding wrapping objects.
 *
 * @author chRyNaN
 * @see [GraphQLType]
 * @see [GraphQLList]
 * @receiver [GraphQLType] The type that will be wrapped in a [GraphQLList].
 * @sample GraphQLString.asList
 */
fun GraphQLType.asList() = GraphQLList(ofType = this)