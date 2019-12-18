package com.chrynan.graphkl.query

@GraphQLQueryMarker
class GraphQLQueryFieldObjectBuilder internal constructor(
        private val name: String,
        private val arguments: List<GraphQLQueryArgument> = emptyList(),
        private val directives: List<GraphQLQueryDirective> = emptyList()
) {

    private val fields = mutableListOf<GraphQLQueryFieldNode>()

    fun field(field: GraphQLQueryField) {
        fields.add(field)
    }

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

    internal fun build() = GraphQLQueryField(
            name = name,
            arguments = arguments,
            nestedFields = fields,
            directives = directives)
}