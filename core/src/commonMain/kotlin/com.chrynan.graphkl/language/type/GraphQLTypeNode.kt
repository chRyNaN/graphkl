package com.chrynan.graphkl.language.type

/**
 * An interface that represents a GraphQL Type as a Node. The GraphQL type may have child Node Types that also implement
 * this interface, through the [childTypeNodes] property. This interface provides an easy way to process all the Types
 * belonging to a GraphQL Schema.
 */
interface GraphQLTypeNode {

    /**
     * A [List] of [GraphQLTypeNode] representing any child Types defined or used within this [GraphQLTypeNode]. If
     * there are no child Nodes then an empty List is returned.
     */
    val childTypeNodes: List<GraphQLTypeNode>
}