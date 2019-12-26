@file:Suppress("unused")

package com.chrynan.graphkl.query.builder

import com.chrynan.graphkl.query.GraphQLQueryArgument
import com.chrynan.graphkl.query.GraphQLQueryDirective
import com.chrynan.graphkl.query.GraphQLQueryField
import com.chrynan.graphkl.query.GraphQLQueryInlineFragment

class GraphQLQueryInlineFragmentBuilder internal constructor(
        private val on: String,
        private val directives: List<GraphQLQueryDirective> = emptyList()
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

    internal fun build() = GraphQLQueryInlineFragment(
            on = on,
            nestedFields = fields,
            directives = directives)
}