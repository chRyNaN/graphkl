package com.chrynan.graphkl.query

sealed class GraphQLQueryFieldNode {

    abstract val nestedFields: List<GraphQLQueryFieldNode>
}

data class GraphQLQueryField(
        val name: String,
        val arguments: List<GraphQLQueryArgument> = emptyList(),
        val directives: List<GraphQLQueryDirective> = emptyList(),
        override val nestedFields: List<GraphQLQueryFieldNode> = emptyList()
) : GraphQLQueryFieldNode()

data class GraphQLQueryFragment(
        val name: String,
        val on: String,
        val directives: List<GraphQLQueryDirective> = emptyList(),
        override val nestedFields: List<GraphQLQueryFieldNode> = emptyList()
) : GraphQLQueryFieldNode()

data class GraphQLQueryNamedFragment(val name: String) : GraphQLQueryFieldNode() {

    override val nestedFields: List<GraphQLQueryFieldNode> = emptyList()
}

data class GraphQLQueryInlineFragment(
        val on: String,
        val directives: List<GraphQLQueryDirective> = emptyList(),
        override val nestedFields: List<GraphQLQueryFieldNode> = emptyList()
) : GraphQLQueryFieldNode()