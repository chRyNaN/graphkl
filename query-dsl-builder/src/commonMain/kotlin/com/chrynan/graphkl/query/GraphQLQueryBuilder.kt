@file:Suppress("unused")

package com.chrynan.graphkl.query

/**
 * A Kotlin DSL builder for creating a [GraphQLQuery].
 *
 * @author chRyNaN
 */
@GraphQLQueryMarker
class GraphQLQueryBuilder internal constructor() {

    private val queries = mutableSetOf<GraphQLQueryRootObject>()
    private val mutations = mutableSetOf<GraphQLQueryRootObject>()
    private val subscriptions = mutableSetOf<GraphQLQueryRootObject>()
    private val variables = mutableSetOf<GraphQLQueryVariable>()
    private val fragments = mutableSetOf<GraphQLQueryFragment>()

    /**
     * Provides a [GraphQLQueryVariable] to the [GraphQLQuery] being created in this builder using the provided [name]
     * and [value]. Note that this is not the definition of a GraphQL Variable on a specific Query, that is represented
     * by the [GraphQLQueryVariableDefinition].
     *
     * @see [GraphQLQueryVariableDefinition]
     *
     * @author chRyNaN
     */
    fun variable(name: String, value: Any?) {
        variables.add(GraphQLQueryVariable(name = name, value = value))
    }

    /**
     * Provides a [GraphQLQueryVariable] to the [GraphQLQuery] being created in this builder using the provided
     * [variable]. Note that this is not the definition of a GraphQL Variable on a specific Query, that is represented
     * by the [GraphQLQueryVariableDefinition].
     *
     * @see [GraphQLQueryVariableDefinition]
     *
     * @author chRyNaN
     */
    fun variable(variable: GraphQLQueryVariable) {
        variables.add(variable)
    }

    /**
     * Provides a [GraphQLQueryVariable] to the [GraphQLQuery] being created in this builder using the provided
     * [variables]. Note that this is not the definition of a GraphQL Variable on a specific Query, that is represented
     * by the [GraphQLQueryVariableDefinition].
     *
     * @see [GraphQLQueryVariableDefinition]
     *
     * @author chRyNaN
     */
    fun variables(variables: Collection<GraphQLQueryVariable>) {
        this.variables.addAll(variables)
    }

    fun query(operationName: String? = null, builder: GraphQLQueryRootObjectBuilder.() -> Unit) {
        val queryBuilder = GraphQLQueryRootObjectBuilder(operationName = operationName, queryType = GraphQLQueryType.QUERY)
        builder.invoke(queryBuilder)
        val query = queryBuilder.build()
        queries.add(query)
    }

    fun mutation(operationName: String? = null, builder: GraphQLQueryRootObjectBuilder.() -> Unit) {
        val mutationBuilder = GraphQLQueryRootObjectBuilder(operationName = operationName, queryType = GraphQLQueryType.MUTATION)
        builder.invoke(mutationBuilder)
        val mutation = mutationBuilder.build()
        mutations.add(mutation)
    }

    fun subscription(operationName: String? = null, builder: GraphQLQueryRootObjectBuilder.() -> Unit) {
        val subscriptionBuilder = GraphQLQueryRootObjectBuilder(operationName = operationName, queryType = GraphQLQueryType.SUBSCRIPTION)
        builder.invoke(subscriptionBuilder)
        val subscription = subscriptionBuilder.build()
        subscriptions.add(subscription)
    }

    fun fragment(name: String, on: String, directives: List<GraphQLQueryDirective> = emptyList(), builder: GraphQLQueryFragmentBuilder.() -> Unit): GraphQLQueryFragment {
        val fragmentBuilder = GraphQLQueryFragmentBuilder(name = name, directives = directives, on = on)
        builder.invoke(fragmentBuilder)
        val fragment = fragmentBuilder.build()
        fragments.add(fragment)
        return fragment
    }

    internal fun build() = GraphQLQuery(
            queries = queries,
            mutations = mutations,
            subscriptions = subscriptions,
            variables = variables,
            fragments = fragments)
}

/**
 * The entry point function for creating a [GraphQLQuery].
 *
 * @param [builder] The builder used to create an instance of [GraphQLQuery], scoped to [GraphQLQueryBuilder].
 *
 * @author chRyNaN
 */
fun graphQL(builder: GraphQLQueryBuilder.() -> Unit): GraphQLQuery {
    val queryBuilder = GraphQLQueryBuilder()
    builder.invoke(queryBuilder)
    return queryBuilder.build()
}