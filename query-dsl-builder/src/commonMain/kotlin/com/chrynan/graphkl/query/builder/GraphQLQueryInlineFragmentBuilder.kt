@file:Suppress("unused")

package com.chrynan.graphkl.query.builder

import com.chrynan.graphkl.query.GraphQLQueryArgument
import com.chrynan.graphkl.query.GraphQLQueryDirective
import com.chrynan.graphkl.query.GraphQLQueryField
import com.chrynan.graphkl.query.GraphQLQueryInlineFragment

class GraphQLQueryInlineFragmentBuilder internal constructor(
        private val on: String,
        private val directives: List<GraphQLQueryDirective> = emptyList()
) : GraphQLQueryFieldBuilder {

    private val fields = mutableListOf<GraphQLQueryField>()

    override fun field(field: GraphQLQueryField) {
        fields.add(field)
    }

    override fun field(name: String, alias: String?, directives: List<GraphQLQueryDirective>) {
        fields.add(GraphQLQueryField(name = name, alias = alias, directives = directives))
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
        val fieldBuilder = GraphQLQueryFieldObjectBuilder(name = name, alias = alias, directives = directives)
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

    internal fun build() = GraphQLQueryInlineFragment(
            on = on,
            nestedFields = fields,
            directives = directives)
}