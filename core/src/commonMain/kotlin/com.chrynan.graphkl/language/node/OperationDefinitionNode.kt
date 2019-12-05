package com.chrynan.graphkl.language.node

import com.chrynan.graphkl.language.Kind
import com.chrynan.graphkl.language.Location
import com.chrynan.graphkl.language.Source

/**
 * A [Node] representing a GraphQL operation within a Query from a [Source]. For example consider the following query:
 *
 * query HeroNameAndFriends {
 *     hero {
 *         name
 *         friends {
 *             name
 *         }
 *     }
 * }
 *
 * In the above GraphQL query, the operation definition is the 'query HeroNameAndFriends' part. The operation type is
 * 'query' and the name of the query is 'HeroNameAndFriends'. An operation definition begins with the operation type
 * ('query') and with the name of the operation ('HereNameAndFriends'). This [Node] represents that whole sequence. The
 * [operation] property represents the operation being performed and the [name] property represents the name of the
 * operation.
 *
 * Note that for an operation type definition, such as in a Schema, refer to the [OperationTypeDefinitionNode].
 */
data class OperationDefinitionNode(
        override val location: Location? = null,
        val operation: OperationTypeNode,
        val name: NameNode,
        val variableDefinitions: List<VariableDefinitionNode> = emptyList(),
        val directives: List<DirectiveNode> = emptyList(),
        val selectionSet: SelectionSetNode
) : BaseNode(kind = Kind.OPERATION_DEFINITION),
        ExecutableDefinitionNode {

    override val childNodes: List<Node> = listOf(name) + variableDefinitions + directives + selectionSet
}