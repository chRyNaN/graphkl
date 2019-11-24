package com.chrynan.graphkl.language.node

/**
 * A [Node] that represents a value passed in from a query. This interface is extended by more specific value node
 * implementations, for example, [FloatValueNode], which defines a provided [Float] value in a GraphQL query.
 */
interface ValueNode<T> : Node {

    val value: T
}