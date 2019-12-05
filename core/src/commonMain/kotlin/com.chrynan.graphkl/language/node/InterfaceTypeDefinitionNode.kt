package com.chrynan.graphkl.language.node

import com.chrynan.graphkl.language.Kind
import com.chrynan.graphkl.language.Location
import com.chrynan.graphkl.language.Source

/**
 * A [Node] that represents the definition of a GraphQL interface from a [Source]. The following is an example of a
 * GraphQL interface definition:
 *
 * interface Character {
 *     id: ID!
 *     name: String!
 *     friends: [Character]
 *     appearsIn: [Episode]!
 * }
 *
 * An interface definition begins with the 'interface' keyword, followed by the name of the interface ('Character'),
 * then brackets surrounding the field definitions. This [Node] represents that whole definition sequence. The [name]
 * property represents the name of the interface ('Character'). The [interfaces] property represents any other
 * interfaces that this interface extends. The [fields] property represents the field definitions of this interface
 * ('id: ID!', 'name: String!', etc). The [directives] property represents any directives on the interface.
 *
 * Note that an interface can be extended by an object which is defined by the [InterfaceTypeExtensionNode].
 */
data class InterfaceTypeDefinitionNode(
        override val location: Location? = null,
        val description: StringValueNode? = null,
        val name: NameNode,
        val interfaces: List<NamedTypeNode> = emptyList(),
        val directives: List<DirectiveNode> = emptyList(),
        val fields: List<FieldDefinitionNode> = emptyList()
) : BaseNode(kind = Kind.INTERFACE_TYPE_DEFINITION),
        TypeDefinitionNode {

    override val childNodes: List<Node> = listOfNotNull(description, name) + interfaces + directives + fields
}