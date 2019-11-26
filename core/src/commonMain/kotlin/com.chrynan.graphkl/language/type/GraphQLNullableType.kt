package com.chrynan.graphkl.language.type

/**
 * A [GraphQLType] interface that represents an output type that can return a null value or an input type that can be
 * passed a null value. This is used in the [GraphQLNonNull] type because that type wraps a nullable value to make it
 * non-null. This interface could be useful for scoping.
 */
interface GraphQLNullableType : GraphQLType