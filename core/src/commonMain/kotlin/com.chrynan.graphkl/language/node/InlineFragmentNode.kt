package com.chrynan.graphkl.language.node

import com.chrynan.graphkl.language.Kind
import com.chrynan.graphkl.language.Location
import com.chrynan.graphkl.language.Source

/**
 * A [Node] representing a GraphQL inline fragment from a [Source]. For example, consider the following GraphQL query:
 *
 * hero(episode: $ep) {
 *     name
 *     ... on Human {
 *         height
 *     }
 * }
 *
 * In the above query, the following section is an inline fragment:
 *
 * ... on Human {
 *     height
 * }
 *
 * An inline fragment begins with the spread operator ('...'), followed by the 'on' keyword, then the type name that the
 * fragment will operator on ('Human'), and finally, the fields of that type that this query will return. This [Node]
 * defines that whole sequence. The [typeCondition] represents the the type that the fragment will operate on, including
 * the fields which the query will return.
 */
data class InlineFragmentNode(
        override val location: Location? = null,
        val typeCondition: NamedTypeNode? = null,
        val directives: List<DirectiveNode> = emptyList(),
        val selectionSet: SelectionSetNode
) : BaseNode(kind = Kind.INLINE_FRAGMENT),
        FragmentNode,
        SelectionNode {

    override val childNodes: List<Node> = listOfNotNull(typeCondition, selectionSet) + directives
}