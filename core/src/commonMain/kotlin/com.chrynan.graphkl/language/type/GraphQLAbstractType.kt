package com.chrynan.graphkl.language.type

/**
 * A [GraphQLType] that is considered abstract, meaning that it is not an implementation in itself. Abstract types are
 * [GraphQLInterfaceType] and [GraphQLUnionType]. Whereas, a [GraphQLObjectType], even one implementing a
 * [GraphQLInterfaceType], is not abstract, but instead an implementation.
 */
interface GraphQLAbstractType : GraphQLType