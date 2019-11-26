package com.chrynan.graphkl.dsl.schema

import com.chrynan.graphkl.language.type.GraphQLObjectType
import com.chrynan.graphkl.language.type.schema.GraphQLSchema

@GraphQLSchemaDslMarker
class GraphQLSchemaBuilder internal constructor() {

    var query: GraphQLObjectType? = null
    var mutation: GraphQLObjectType? = null
    var subscription: GraphQLObjectType? = null

    fun query(builder: GraphQLObjectBuilder.() -> Unit) {
        val objectBuilder = GraphQLObjectBuilder()
        builder.invoke(objectBuilder)
        query = objectBuilder.build()
    }

    fun mutation(builder: GraphQLObjectBuilder.() -> Unit) {
        val objectBuilder = GraphQLObjectBuilder()
        builder.invoke(objectBuilder)
        mutation = objectBuilder.build()
    }

    fun subscription(builder: GraphQLObjectBuilder.() -> Unit) {
        val objectBuilder = GraphQLObjectBuilder()
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