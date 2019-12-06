package com.chrynan.graphkl.language.type

interface GraphQLTypeNode {

    val childTypeNodes: List<GraphQLTypeNode>
}