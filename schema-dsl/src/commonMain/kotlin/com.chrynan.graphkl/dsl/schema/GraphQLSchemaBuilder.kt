package com.chrynan.graphkl.dsl.schema

import com.chrynan.graphkl.language.type.GraphQLObjectType
import com.chrynan.graphkl.language.type.schema.GraphQLSchema

@GraphQLSchemaDslMarker
class GraphQLSchemaBuilder internal constructor() {

    var query: GraphQLObjectType? = null
    var mutation: GraphQLObjectType? = null
    var subscription: GraphQLObjectType? = null

    fun query(name: String? = null, builder: GraphQLObjectBuilder.() -> Unit) {
        val objectBuilder = GraphQLObjectBuilder(initialName = name)
        builder.invoke(objectBuilder)
        query = objectBuilder.build()
    }

    fun mutation(name: String? = null, builder: GraphQLObjectBuilder.() -> Unit) {
        val objectBuilder = GraphQLObjectBuilder(initialName = name)
        builder.invoke(objectBuilder)
        mutation = objectBuilder.build()
    }

    fun subscription(name: String? = null, builder: GraphQLObjectBuilder.() -> Unit) {
        val objectBuilder = GraphQLObjectBuilder(initialName = name)
        builder.invoke(objectBuilder)
        subscription = objectBuilder.build()
    }

    internal fun build(): GraphQLSchema =
            GraphQLSchema(
                    queryType = query,
                    mutationType = mutation,
                    subscriptionType = subscription)
}

fun schema(builder: GraphQLSchemaBuilder.() -> Unit): GraphQLSchema {
    val schemaBuilder = GraphQLSchemaBuilder()
    builder.invoke(schemaBuilder)
    return schemaBuilder.build()
}