package com.chrynan.graphkl.query

@GraphQLQueryMarker
class GraphQLQueryRootObjectBuilder internal constructor(
        private val operationName: String? = null,
        private val queryType: GraphQLQueryType = GraphQLQueryType.QUERY
) {

    private val fields = mutableListOf<GraphQLQueryField>()

    fun field(name: String, directives: List<GraphQLQueryDirective> = emptyList()) {
        fields.add(GraphQLQueryField(name = name, directives = directives))
    }

    fun field(name: String, vararg args: Pair<String, Any?>, directives: List<GraphQLQueryDirective> = emptyList()) {
        fields.add(GraphQLQueryField(
                name = name,
                arguments = args.map { GraphQLQueryArgument(name = it.first, value = it.second) },
                directives = directives))
    }

    fun field(name: String, args: Map<String, Any?>, directives: List<GraphQLQueryDirective> = emptyList()) {
        fields.add(GraphQLQueryField(
                name = name,
                arguments = args.map { GraphQLQueryArgument(name = it.key, value = it.value) },
                directives = directives))
    }

    fun field(name: String, directives: List<GraphQLQueryDirective> = emptyList(), builder: GraphQLQueryFieldObjectBuilder.() -> Unit) {
        val fieldBuilder = GraphQLQueryFieldObjectBuilder(name = name, directives = directives)
        builder.invoke(fieldBuilder)
        fields.add(fieldBuilder.build())
    }

    fun field(name: String, vararg args: Pair<String, Any?>, directives: List<GraphQLQueryDirective> = emptyList(), builder: GraphQLQueryFieldObjectBuilder.() -> Unit) {
        val fieldBuilder = GraphQLQueryFieldObjectBuilder(
                name = name,
                arguments = args.map { GraphQLQueryArgument(name = it.first, value = it.second) },
                directives = directives)
        builder.invoke(fieldBuilder)
        fields.add(fieldBuilder.build())
    }

    fun field(name: String, args: Map<String, Any?>, directives: List<GraphQLQueryDirective> = emptyList(), builder: GraphQLQueryFieldObjectBuilder.() -> Unit) {
        val fieldBuilder = GraphQLQueryFieldObjectBuilder(
                name = name,
                arguments = args.map { GraphQLQueryArgument(name = it.key, value = it.value) },
                directives = directives)
        builder.invoke(fieldBuilder)
        fields.add(fieldBuilder.build())
    }

    internal fun build() = GraphQLQueryRootObject(
            operationName = operationName,
            queryType = queryType,
            nestedFields = fields)
}