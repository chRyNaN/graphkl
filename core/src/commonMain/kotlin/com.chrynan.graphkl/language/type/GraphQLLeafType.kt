package com.chrynan.graphkl.language.type

/**
 * An interface representing a [GraphQLType] that does not have any fields that can be queried. If a field that is a
 * leaf type is queried, there are no nested fields to be queried, so the value will be returned. GraphQL leaf types are
 * enums and scalars. This interface can be useful for scoping.
 */
interface GraphQLLeafType : GraphQLType