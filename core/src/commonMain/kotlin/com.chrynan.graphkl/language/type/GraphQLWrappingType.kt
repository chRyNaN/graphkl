package com.chrynan.graphkl.language.type

/**
 * A [GraphQLType] interface that represents a type that wraps another type. The two wrapping types are [GraphQLList]
 * and [GraphQLNonNull]. This interface could be useful for scoping.
 */
interface GraphQLWrappingType : GraphQLType