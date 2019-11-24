package com.chrynan.graphkl.language.node

import com.chrynan.graphkl.language.Kind
import com.chrynan.graphkl.language.Location
import com.chrynan.graphkl.language.Source

/**
 * A [Node] representing a GraphQL directive within a query from a [Source]. For example, consider the following query:
 *
 * hero(episode: $episode) {
 *     name
 *     friends @include(if: $withFriends) {
 *         name
 *     }
 * }
 *
 * In the above query, the '@include(if: $withFriends)' is a directive. A directive begins with the '@' character,
 * followed by parentheses containing optional arguments. This [Node] represents that whole sequence. The [name]
 * property represents the name of the directive ('include'). The [arguments] property represents the arguments of the
 * directive.
 *
 * Note that this refers to the directive value provided within a query. For information about defining a directive in a
 * Schema, refer to the [DirectiveDefinitionNode].
 */
data class DirectiveNode(
        override val location: Location? = null,
        val name: NameNode,
        val arguments: List<ArgumentNode> = emptyList()
) : BaseNode(kind = Kind.DIRECTIVE)