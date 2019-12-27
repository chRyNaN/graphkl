@file:Suppress("unused")

package com.chrynan.graphkl.query.builder

import com.chrynan.graphkl.query.*

@GraphQLQueryMarker
class GraphQLQueryFieldObjectBuilder internal constructor(
        private val name: String,
        private val alias: String? = null,
        private val arguments: List<GraphQLQueryArgument> = emptyList(),
        private val directives: List<GraphQLQueryDirective> = emptyList()
) : GraphQLQueryFieldBuilder {

    private val fields = mutableListOf<GraphQLQueryFieldNode>()

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

    internal fun build() = GraphQLQueryField(
            name = name,
            alias = alias,
            arguments = arguments,
            nestedFields = fields,
            directives = directives)
}