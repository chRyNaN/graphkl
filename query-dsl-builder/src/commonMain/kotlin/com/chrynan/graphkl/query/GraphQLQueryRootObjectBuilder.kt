package com.chrynan.graphkl.query

@GraphQLQueryMarker
class GraphQLQueryRootObjectBuilder internal constructor(private val queryType: GraphQLQueryType = GraphQLQueryType.QUERY) {

    private val fields = mutableListOf<GraphQLQueryField>()

    fun field(name: String) {
        fields.add(GraphQLQueryField(name = name))
    }

    fun field(name: String, vararg args: Pair<String, Any?>) {
        fields.add(GraphQLQueryField(name = name, arguments = args.map { GraphQLQueryArgument(name = it.first, value = it.second) }))
    }

    fun field(name: String, args: Map<String, Any?>) {
        fields.add(GraphQLQueryField(name = name, arguments = args.map { GraphQLQueryArgument(name = it.key, value = it.value) }))
    }

    fun field(name: String, builder: GraphQLQueryFieldObjectBuilder.() -> Unit) {
        val fieldBuilder = GraphQLQueryFieldObjectBuilder(name = name)
        builder.invoke(fieldBuilder)
        fields.add(fieldBuilder.build())
    }

    fun field(name: String, vararg args: Pair<String, Any?>, builder: GraphQLQueryFieldObjectBuilder.() -> Unit) {
        val fieldBuilder = GraphQLQueryFieldObjectBuilder(name = name, arguments = args.map { GraphQLQueryArgument(name = it.first, value = it.second) })
        builder.invoke(fieldBuilder)
        fields.add(fieldBuilder.build())
    }

    fun field(name: String, args: Map<String, Any?>, builder: GraphQLQueryFieldObjectBuilder.() -> Unit) {
        val fieldBuilder = GraphQLQueryFieldObjectBuilder(name = name, arguments = args.map { GraphQLQueryArgument(name = it.key, value = it.value) })
        builder.invoke(fieldBuilder)
        fields.add(fieldBuilder.build())
    }

    internal fun build() = GraphQLQueryRootObject(queryType = queryType, nestedFields = fields)
}