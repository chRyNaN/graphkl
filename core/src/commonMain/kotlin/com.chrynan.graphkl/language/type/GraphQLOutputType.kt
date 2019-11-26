package com.chrynan.graphkl.language.type

/**
 * A [GraphQLType] that represents an output value. An output value can be returned from a query. Input types cannot
 * also be an output type, and vice-versa, with the exceptions of enums, default scalars, lists of input types, and
 * non-null input types. This interface could be useful for scoping.
 */
interface GraphQLOutputType : GraphQLType