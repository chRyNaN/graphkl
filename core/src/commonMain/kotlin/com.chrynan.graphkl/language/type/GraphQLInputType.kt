package com.chrynan.graphkl.language.type

/**
 * A [GraphQLType] that represents an input value. An input type can be passed into a query, such as in an argument, but
 * cannot be returned by a query. Input types cannot also be an output type, and vice-versa, with the exceptions of
 * enums, default scalars, lists of input types, and non-null input types. This interface could be useful for scoping.
 */
interface GraphQLInputType : GraphQLType