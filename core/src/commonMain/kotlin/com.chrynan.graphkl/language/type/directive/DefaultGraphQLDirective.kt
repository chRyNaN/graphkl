package com.chrynan.graphkl.language.type.directive

import com.chrynan.graphkl.language.type.GraphQLArgument

sealed class DefaultGraphQLDirective(
        name: String,
        description: String? = null,
        locations: List<String> = emptyList(),
        args: List<GraphQLArgument> = emptyList(),
        isRepeatable: Boolean = false
) : GraphQLDirective(
        name = name,
        description = description,
        locations = locations,
        args = args,
        isRepeatable = isRepeatable
)

object GraphQLIncludeDirective : DefaultGraphQLDirective(
        name = "include",
        description = "Directs the executor to include this field or fragment only when the `if` argument is true."
)

object GraphQLSkipDirective : DefaultGraphQLDirective(
        name = "skip",
        description = "Directs the executor to skip this field or fragment when the `if` argument is true."
)

object GraphQLDeprecatedDirective : DefaultGraphQLDirective(
        name = "deprecated",
        description = "Marks an element of a GraphQL schema as no longer supported."
)