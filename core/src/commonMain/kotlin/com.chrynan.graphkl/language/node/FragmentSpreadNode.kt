package com.chrynan.graphkl.language.node

import com.chrynan.graphkl.language.Kind
import com.chrynan.graphkl.language.Location
import com.chrynan.graphkl.language.Source

/**
 * A [Node] representing the use of a GraphQL fragment in a query, from a [Source]. For example, consider the following
 * GraphQL query:
 *
 * {
 *     leftComparison: hero(episode: EMPIRE) {
 *         ...comparisonFields
 *     }
 *     rightComparison: hero(episode: JEDI) {
 *         ...comparisonFields
 *     }
 * }
 *
 * In the above query, the use of a fragment is declared by the following:
 *
 * ...comparisonFields
 *
 * The usage of a fragment begins with the spread operator ('...'), followed by the fragment name. This [Node] defines
 * that whole sequence. The [name] property represents the name of the defined fragment being used.
 */
data class FragmentSpreadNode(
        override val location: Location? = null,
        val name: NameNode,
        val directives: List<DirectiveNode> = emptyList()
) : BaseNode(kind = Kind.FRAGMENT_SPREAD),
        FragmentNode,
        SelectionNode {

    override val childNodes: List<Node> = listOf(name) + directives
}