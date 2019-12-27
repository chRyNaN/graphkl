package com.chrynan.graphkl.query.builder

import com.chrynan.graphkl.query.GraphQLQueryDirective
import com.chrynan.graphkl.query.GraphQLQueryField

interface GraphQLQueryFieldBuilder {

    fun field(field: GraphQLQueryField)

    fun field(name: String, alias: String? = null, directives: List<GraphQLQueryDirective> = emptyList())

    fun field(
            name: String,
            vararg args: Pair<String, Any?>,
            alias: String? = null,
            directives: List<GraphQLQueryDirective> = emptyList())

    fun field(
            name: String,
            args: Map<String, Any?>,
            alias: String? = null,
            directives: List<GraphQLQueryDirective> = emptyList())

    fun field(
            name: String,
            alias: String? = null,
            directives: List<GraphQLQueryDirective> = emptyList(),
            builder: GraphQLQueryFieldObjectBuilder.() -> Unit)

    fun field(
            name: String,
            vararg args: Pair<String, Any?>,
            alias: String? = null,
            directives: List<GraphQLQueryDirective> = emptyList(),
            builder: GraphQLQueryFieldObjectBuilder.() -> Unit)

    fun field(
            name: String,
            args: Map<String, Any?>,
            alias: String? = null,
            directives: List<GraphQLQueryDirective> = emptyList(),
            builder: GraphQLQueryFieldObjectBuilder.() -> Unit)
}