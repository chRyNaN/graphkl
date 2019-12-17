package com.chrynan.graphkl.query

fun graphQLQuery(builder: GraphQLQueryRootObjectBuilder.() -> Unit): GraphQLQuery {
    val rootBuilder = GraphQLQueryRootObjectBuilder(queryType = GraphQLQueryType.QUERY)
    builder.invoke(rootBuilder)
    val root = rootBuilder.build()
    return GraphQLQuery(root = root)
}

fun graphQLMutation(builder: GraphQLQueryRootObjectBuilder.() -> Unit): GraphQLQuery {
    val rootBuilder = GraphQLQueryRootObjectBuilder(queryType = GraphQLQueryType.MUTATION)
    builder.invoke(rootBuilder)
    val root = rootBuilder.build()
    return GraphQLQuery(root = root)
}

fun graphQLSubscription(builder: GraphQLQueryRootObjectBuilder.() -> Unit): GraphQLQuery {
    val rootBuilder = GraphQLQueryRootObjectBuilder(queryType = GraphQLQueryType.SUBSCRIPTION)
    builder.invoke(rootBuilder)
    val root = rootBuilder.build()
    return GraphQLQuery(root = root)
}