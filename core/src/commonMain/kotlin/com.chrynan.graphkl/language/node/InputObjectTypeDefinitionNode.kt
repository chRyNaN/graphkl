package com.chrynan.graphkl.language.node

import com.chrynan.graphkl.language.Kind
import com.chrynan.graphkl.language.Location
import com.chrynan.graphkl.language.Source

/**
 * A [Node] representing an input object type definition in a GraphQL Schema from a [Source]. The following is an
 * example of an input object type definition:
 *
 * input ReviewInput {
 *     stars: Int!
 *     commentary: String
 * }
 *
 * An input object type definition begins with the 'input' keyword, followed by the name of the input object
 * ('ReviewInput'), then brackets ('{') containing input value field definitions of the input object
 * ('starts: Int!', etc). This [Node] represents that whole definition sequence. The [name] property represents the name
 * of the input object ('ReviewInput'). The [fields] property represents the fields of this input object.
 */
data class InputObjectTypeDefinitionNode(
        override val location: Location? = null,
        val description: StringValueNode? = null,
        val name: NameNode,
        val directives: List<DirectiveNode> = emptyList(),
        val fields: List<InputValueDefinitionNode> = emptyList()
) : BaseNode(kind = Kind.INPUT_OBJECT_TYPE_DEFINITION),
        TypeDefinitionNode {

    override val childNodes: List<Node> = listOfNotNull(description, name) + directives + fields
}