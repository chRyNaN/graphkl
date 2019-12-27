@file:Suppress("unused")

package com.chrynan.graphkl.query.builder

import com.chrynan.graphkl.query.*

@GraphQLQueryMarker
class GraphQLQueryRootObjectBuilder internal constructor(
        private val operationName: String? = null,
        private val queryType: GraphQLQueryType = GraphQLQueryType.QUERY
) : GraphQLQueryFieldBuilder {

    private val fields = mutableListOf<GraphQLQueryFieldNode>()
    private val variableDefinitions = mutableListOf<GraphQLQueryVariableDefinition>()

    fun variableDefinition(name: String, typeName: String, defaultValue: Any? = null) {
        variableDefinitions.add(GraphQLQueryVariableDefinition(name = name, typeName = typeName, defaultValue = defaultValue))
    }

    fun variableDefinition(variable: GraphQLQueryVariableDefinition) {
        variableDefinitions.add(variable)
    }

    fun variableDefinitions(variables: Collection<GraphQLQueryVariableDefinition>) {
        this.variableDefinitions.addAll(variables)
    }

    override fun field(field: GraphQLQueryField) {
        fields.add(field)
    }

    override fun field(name: String, alias: String?, directives: List<GraphQLQueryDirective>) {
        fields.add(GraphQLQueryField(name = name, directives = directives, alias = alias))
    }

    override fun field(name: String, vararg args: Pair<String, Any?>, alias: String?, directives: List<GraphQLQueryDirective>) {
        fields.add(GraphQLQueryField(
                name = name,
                alias = alias,
                arguments = args.map { GraphQLQueryArgument(name = it.first, value = it.second) },
                directives = directives))
    }

    override fun field(name: String, args: Map<String, Any?>, alias: String?, directives: List<GraphQLQueryDirective>) {
        fields.add(GraphQLQueryField(
                name = name,
                alias = alias,
                arguments = args.map { GraphQLQueryArgument(name = it.key, value = it.value) },
                directives = directives))
    }

    override fun field(name: String, alias: String?, directives: List<GraphQLQueryDirective>, builder: GraphQLQueryFieldObjectBuilder.() -> Unit) {
        val fieldBuilder = GraphQLQueryFieldObjectBuilder(name = name, directives = directives, alias = alias)
        builder.invoke(fieldBuilder)
        fields.add(fieldBuilder.build())
    }

    override fun field(name: String, vararg args: Pair<String, Any?>, alias: String?, directives: List<GraphQLQueryDirective>, builder: GraphQLQueryFieldObjectBuilder.() -> Unit) {
        val fieldBuilder = GraphQLQueryFieldObjectBuilder(
                name = name,
                alias = alias,
                arguments = args.map { GraphQLQueryArgument(name = it.first, value = it.second) },
                directives = directives)
        builder.invoke(fieldBuilder)
        fields.add(fieldBuilder.build())
    }

    override fun field(name: String, args: Map<String, Any?>, alias: String?, directives: List<GraphQLQueryDirective>, builder: GraphQLQueryFieldObjectBuilder.() -> Unit) {
        val fieldBuilder = GraphQLQueryFieldObjectBuilder(
                name = name,
                alias = alias,
                arguments = args.map { GraphQLQueryArgument(name = it.key, value = it.value) },
                directives = directives)
        builder.invoke(fieldBuilder)
        fields.add(fieldBuilder.build())
    }

    fun fromFragment(fragment: GraphQLQueryFragment) {
        fields.add(fragment)
    }

    fun fromFragment(name: String) {
        fields.add(GraphQLQueryNamedFragment(name = name))
    }

    fun inlineFragment(on: String, directives: List<GraphQLQueryDirective> = emptyList(), builder: GraphQLQueryInlineFragmentBuilder.() -> Unit) {
        val fragmentBuilder = GraphQLQueryInlineFragmentBuilder(on = on, directives = directives)
        builder.invoke(fragmentBuilder)
        fields.add(fragmentBuilder.build())
    }

    internal fun build() = GraphQLQueryRootObject(
            operationName = operationName,
            operationType = queryType,
            variableDefinitions = variableDefinitions,
            nestedFields = fields)
}