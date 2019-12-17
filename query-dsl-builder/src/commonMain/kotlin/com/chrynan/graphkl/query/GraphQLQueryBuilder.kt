package com.chrynan.graphkl.query

@GraphQLQueryMarker
class GraphQLQueryBuilder internal constructor() {

    private val queries = mutableSetOf<GraphQLQueryRootObject>()
    private val mutations = mutableSetOf<GraphQLQueryRootObject>()
    private val subscriptions = mutableSetOf<GraphQLQueryRootObject>()
    private val variables = mutableSetOf<GraphQLQueryVariable>()

    fun variable(name: String, value: Any?, defaultValue: Any? = null) {
        variables.add(GraphQLQueryVariable(name = name, value = value, defaultValue = defaultValue))
    }

    fun variable(variable: GraphQLQueryVariable) {
        variables.add(variable)
    }

    fun variables(variables: Collection<GraphQLQueryVariable>) {
        this.variables.addAll(variables)
    }

    fun query(operationName: String? = null, builder: GraphQLQueryRootObjectBuilder.() -> Unit) {
        val queryBuilder = GraphQLQueryRootObjectBuilder(queryType = GraphQLQueryType.QUERY)
        builder.invoke(queryBuilder)
        val query = queryBuilder.build()
        queries.add(query)
    }

    fun mutation(operationName: String? = null, builder: GraphQLQueryRootObjectBuilder.() -> Unit) {
        val mutationBuilder = GraphQLQueryRootObjectBuilder(queryType = GraphQLQueryType.MUTATION)
        builder.invoke(mutationBuilder)
        val mutation = mutationBuilder.build()
        mutations.add(mutation)
    }

    fun subscription(operationName: String? = null, builder: GraphQLQueryRootObjectBuilder.() -> Unit) {
        val subscriptionBuilder = GraphQLQueryRootObjectBuilder(queryType = GraphQLQueryType.SUBSCRIPTION)
        builder.invoke(subscriptionBuilder)
        val subscription = subscriptionBuilder.build()
        subscriptions.add(subscription)
    }

    internal fun build() = GraphQLQuery(
            queries = queries,
            mutations = mutations,
            subscriptions = subscriptions,
            variables = variables)
}

fun graphQL(builder: GraphQLQueryBuilder.() -> Unit): GraphQLQuery {
    val queryBuilder = GraphQLQueryBuilder()
    builder.invoke(queryBuilder)
    return queryBuilder.build()
}