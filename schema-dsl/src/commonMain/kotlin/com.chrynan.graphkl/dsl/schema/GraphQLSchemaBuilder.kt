package com.chrynan.graphkl.dsl.schema

import com.chrynan.graphkl.language.type.GraphQLNamedType
import com.chrynan.graphkl.language.type.GraphQLObjectType
import com.chrynan.graphkl.language.type.directive.GraphQLDirective
import com.chrynan.graphkl.language.type.schema.GraphQLSchema

/**
 * A DSL builder class for creating a [GraphQLSchema]. Instead of instantiating a [GraphQLSchema] type, this builder
 * class can be used, via the [schema] function, to create an instance of a [GraphQLSchema] in a Kotlin DSL manner.
 */
@GraphQLSchemaDslMarker
class GraphQLSchemaBuilder internal constructor() {

    var query: GraphQLObjectType? = null
    var mutation: GraphQLObjectType? = null
    var subscription: GraphQLObjectType? = null

    private val extraTypes = mutableListOf<GraphQLNamedType>()
    private val directives = mutableListOf<GraphQLDirective>()

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

    fun includeType(type: GraphQLNamedType) {
        extraTypes.add(type)
    }

    fun includeTypes(types: List<GraphQLNamedType>) {
        extraTypes.addAll(types)
    }

    fun includeDirective(directive: GraphQLDirective) {
        directives.add(directive)
    }

    fun includeDirectives(directives: List<GraphQLDirective>) {
        this.directives.addAll(directives)
    }

    internal fun build(): GraphQLSchema =
            GraphQLSchema(
                    queryType = query,
                    mutationType = mutation,
                    subscriptionType = subscription,
                    extraTypes = extraTypes,
                    directives = directives)
}

/**
 * The entry point function in creating a [GraphQLSchema] in a Kotlin DSL manner.
 *
 * @author chRyNaN
 * @see [GraphQLSchema]
 * @param [builder] The builder used to create a [GraphQLSchema] in the scope of [GraphQLSchemaBuilder].
 * @return [GraphQLSchema] A [GraphQLSchema] instance representing the result of the provided [builder].
 */
fun schema(builder: GraphQLSchemaBuilder.() -> Unit): GraphQLSchema {
    val schemaBuilder = GraphQLSchemaBuilder()
    builder.invoke(schemaBuilder)
    return schemaBuilder.build()
}