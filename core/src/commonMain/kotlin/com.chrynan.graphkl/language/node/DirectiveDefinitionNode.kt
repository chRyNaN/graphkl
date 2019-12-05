package com.chrynan.graphkl.language.node

import com.chrynan.graphkl.language.Kind
import com.chrynan.graphkl.language.Location
import com.chrynan.graphkl.language.Source

/**
 * A [Node] representing a GraphQL directive definition within a Schema, for a [Source]. A directive definition is an
 * annotation with optional arguments, specified on a field or fragment inclusion, that affects the result of a query.
 * There are two directives that are included in the GraphQL specification. These are:
 *
 * \@include(if: Boolean) Only include this field in the result if the argument is true.
 * \@skip(if: Boolean) Skip this field if the argument is true.
 *
 * A directive definition begins with the '@' character, followed by the name of the directive ('include'), then within
 * parentheses, the arguments are provided ('if: Boolean'). This [Node] represents that whole definition sequence.
 * The [name] property represents the name of the directive. The [arguments] property represents the list of arguments.
 *
 * Note that for a directive included in a query, refer to the [DirectiveNode].
 */
data class DirectiveDefinitionNode(
        override val location: Location? = null,
        val description: StringValueNode? = null,
        val name: NameNode,
        val arguments: List<InputValueDefinitionNode> = emptyList(),
        val repeatable: Boolean,
        val locations: List<NameNode> = emptyList()
) : BaseNode(kind = Kind.DIRECTIVE_DEFINITION),
        TypeSystemDefinitionNode {

    override val childNodes: List<Node> = listOfNotNull(description, name) + arguments + locations
}