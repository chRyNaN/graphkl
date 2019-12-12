package com.chrynan.graphkl.language.type

import com.chrynan.graphkl.language.type.schema.GraphQLSchema

/**
 * An interface that represents a root [GraphQLTypeNode] or the start of the tree defining [GraphQLTypeNode]s. This is
 * implemented by the [GraphQLSchema] object.
 */
interface GraphQLRootTypeNode : GraphQLTypeNode