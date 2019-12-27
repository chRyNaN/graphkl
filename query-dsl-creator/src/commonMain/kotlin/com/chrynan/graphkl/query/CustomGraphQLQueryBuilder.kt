package com.chrynan.graphkl.query

import com.chrynan.graphkl.query.builder.GraphQLQueryBuilder
import com.chrynan.graphkl.query.builder.GraphQLQueryFieldObjectBuilder
import com.chrynan.graphkl.query.builder.GraphQLQueryRootObjectBuilder
import com.chrynan.graphkl.query.builder.graphQL

class CustomGraphQLQueryBuilder(internal val queryBuilder: GraphQLQueryBuilder) {

    fun query(operationName: String? = null, builder: CustomGraphQLQueryRootObjectBuilder.() -> Unit) {
        queryBuilder.query(operationName = operationName) {
            builder.invoke(CustomGraphQLQueryRootObjectBuilder(this))
        }
    }

    fun mutation(operationName: String? = null, builder: CustomGraphQLQueryRootObjectBuilder.() -> Unit) {
        queryBuilder.mutation(operationName = operationName) {
            builder.invoke(CustomGraphQLQueryRootObjectBuilder(this))
        }
    }

    fun subscription(operationName: String? = null, builder: CustomGraphQLQueryRootObjectBuilder.() -> Unit) {
        queryBuilder.subscription(operationName = operationName) {
            builder.invoke(CustomGraphQLQueryRootObjectBuilder(this))
        }
    }
}

fun CustomGraphQLQueryBuilder.test() {
    queryBuilder.query { }
}

class CustomGraphQLQueryRootObjectBuilder(private val rootQueryBuilder: GraphQLQueryRootObjectBuilder) {

    val name: Unit
        get() = rootQueryBuilder.field(name = "name")

    fun name(alias: String? = null) {
        rootQueryBuilder.field(name = "name", alias = alias)
    }

    fun date(format: String) {
        rootQueryBuilder.field("date", "format" to format)
    }

    fun obj(builder: CustomGraphQLFieldObjectBuilder.() -> Unit) {
        rootQueryBuilder.field("obj", "") {
            builder.invoke(CustomGraphQLFieldObjectBuilder(this))
        }
    }
}

class CustomGraphQLFieldObjectBuilder(private val builder: GraphQLQueryFieldObjectBuilder) {

}

fun testGraphQL(builder: CustomGraphQLQueryBuilder.() -> Unit) =
        graphQL {
            builder.invoke(CustomGraphQLQueryBuilder(this))
        }

fun test() {
    testGraphQL {
        query {
            name
            date("")
            obj {

            }
        }
    }
}