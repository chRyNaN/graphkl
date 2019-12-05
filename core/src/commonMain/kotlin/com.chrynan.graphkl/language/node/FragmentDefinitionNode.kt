package com.chrynan.graphkl.language.node

import com.chrynan.graphkl.language.Kind
import com.chrynan.graphkl.language.Location
import com.chrynan.graphkl.language.Source

/**
 * A [Node] representing a GraphQL fragment definition, such as in a query, from a [Source]. A fragment definition is a
 * declaration of a fragment including any fields contained within the fragment. For example, the following is a
 * fragment definition:
 *
 * fragment comparisonFields on Character {
 *     name
 *     appearsIn
 *     friends {
 *         name
 *     }
 * }
 *
 * The fragment definition contains the declaration of the fragment, beginning with the 'fragment' keyword and including
 * the name of the fragment ('comparisonFields'), the type the fragment will operate on ('on Character'), and the fields
 * of that type that will be returned when this fragment is used ('name', etc). This [Node] defines that whole
 * definition sequence.
 *
 * Then [name] property represents the name of the fragment ('comparisonFields'). The [typeCondition] represents the
 * type this fragment operates on ('Character') and the fields that this fragment contains ('name', etc).
 * And the [variableDefinitions] represents the list of variables that this fragment accesses (See the
 * [VariableDefinitionNode] KDoc for more information).
 *
 * Note that the [FragmentSpreadNode] is the use of a fragment definition within a query. And the [InlineFragmentNode]
 * is both the definition and use of an inline fragment.
 */
data class FragmentDefinitionNode(
        override val location: Location? = null,
        val name: NameNode,
        val variableDefinitions: List<VariableDefinitionNode> = emptyList(),
        val typeCondition: NamedTypeNode,
        val directives: List<DirectiveNode> = emptyList(),
        val selectionSet: SelectionSetNode
) : BaseNode(kind = Kind.FRAGMENT_DEFINITION),
        ExecutableDefinitionNode {

    override val childNodes: List<Node> = listOf(name, typeCondition, selectionSet) + variableDefinitions + directives
}