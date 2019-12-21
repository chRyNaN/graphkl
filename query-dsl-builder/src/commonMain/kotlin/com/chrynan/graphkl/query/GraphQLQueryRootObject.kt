@file:Suppress("MemberVisibilityCanBePrivate")

package com.chrynan.graphkl.query

/**
 * Represents a root object for a GraphQL Query (Query, Mutation, or Subscription type).
 *
 * @property [operationName] The name of the GraphQL root Query.
 * @property [operationType] The [GraphQLQueryType] this root GraphQL Query object represents.
 * @property [variableDefinitions] Any [GraphQLQueryVariableDefinition]s specified on this root Query.
 * @property [nestedFields] The [GraphQLQueryFieldNode]s belonging to this object.
 *
 * @author chRyNaN
 */
data class GraphQLQueryRootObject(
        val operationName: String? = null,
        val operationType: GraphQLQueryType = GraphQLQueryType.QUERY,
        val variableDefinitions: List<GraphQLQueryVariableDefinition> = emptyList(),
        val nestedFields: List<GraphQLQueryFieldNode>
) {

    val queryName: String
        get() = buildString {
            append(operationType.queryName)

            if (operationName != null) {
                append(operationName)
            }
        }

    val invocationName: String
        get() = buildString {
            append(queryName)

            if (variableDefinitions.isNotEmpty()) {
                append("(")

                variableDefinitions.forEachIndexed { index, variable ->
                    append(variable)

                    if (index != variableDefinitions.lastIndex) {
                        append(", ")
                    }
                }

                append(")")
            }
        }

    @Suppress("unused")
    fun toRequestString(): String = buildString {
        append(invocationName)

        append(" { \\n ")

        nestedFields.forEach { append("${it.toPrettyString()} \\n ") }

        append("}")
    }

    @Suppress("MemberVisibilityCanBePrivate")
    fun toPrettyString(): String = buildString {
        append(invocationName)

        append(" {\n ")

        nestedFields.forEach { append("${it.toPrettyString()}\n ") }

        append("}")
    }

    override fun toString() = toPrettyString()
}