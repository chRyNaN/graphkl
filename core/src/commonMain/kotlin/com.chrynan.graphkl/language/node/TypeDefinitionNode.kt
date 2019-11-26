package com.chrynan.graphkl.language.node

import com.chrynan.graphkl.language.Source

/**
 * A [Node] that represents an object, scalar, union, or input object GraphQL type definition within a Schema from a
 * [Source]. This is a definition node specifically for GraphQL types. This is useful for scoping.
 */
interface TypeDefinitionNode : Node,
        TypeSystemDefinitionNode