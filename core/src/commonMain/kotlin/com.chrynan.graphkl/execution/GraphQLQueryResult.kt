package com.chrynan.graphkl.execution

import com.chrynan.graphkl.error.GraphQLError

/**
 * A class representing the returned result of a GraphQL Query. This class is just a simple wrapper conforming to the
 * GraphQL standards of the result object. The [data] field represents the result of the GraphQL Query. The [errors]
 * field represents any errors encountered when attempting to execute the GraphQL Query. This class doesn't handle any
 * serialization. The serialization mechanism is independent from this library and the library User can choose which
 * format and library to use to serialize the result.
 */
data class GraphQLQueryResult<T>(
        val data: T,
        val errors: List<GraphQLError> = emptyList()
)