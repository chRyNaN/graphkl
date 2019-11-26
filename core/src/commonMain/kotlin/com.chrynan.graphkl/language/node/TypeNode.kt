package com.chrynan.graphkl.language.node

/**
 * A base [Node] for all GraphQL types within a Schema or Query. All types extend from this interface (scalars, objects,
 * etc). This is useful for scoping.
 */
interface TypeNode : Node