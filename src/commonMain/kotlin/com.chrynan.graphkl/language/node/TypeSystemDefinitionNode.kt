package com.chrynan.graphkl.language.node

import com.chrynan.graphkl.language.Source

/**
 * A [Node] that represents a definition for the declared GraphQL type system from a [Source]. This can represent a
 * directive, schema, or type definition. This is useful for scoping.
 */
interface TypeSystemDefinitionNode : Node,
        DefinitionNode