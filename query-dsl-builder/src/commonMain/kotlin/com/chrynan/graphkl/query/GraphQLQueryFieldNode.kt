package com.chrynan.graphkl.query

interface GraphQLQueryFieldNode {

    val nestedFields: List<GraphQLQueryFieldNode>
}