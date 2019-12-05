package com.chrynan.graphkl.language.node

import com.chrynan.graphkl.language.Kind
import com.chrynan.graphkl.language.Location
import com.chrynan.graphkl.language.Source

/**
 * A [Node] representing the extension of a GraphQL Interface from an Object, from a [Source]. For example, consider the
 * following GraphQL Object definition:
 *
 * type Human implements Character {
 *     id: ID!
 *     name: String!
 *     friends: [Character]
 *     appearsIn: [Episode]!
 *     starships: [Starship]
 *     totalCredits: Int
 * }
 *
 * In the above GraphQL, the object type 'Human' extends from the interface 'Character'. An object extending from an
 * interface must provide all the fields from that interface. The 'implements Character', in the above GraphQL,
 * represents an interface extension. An interface extension beings with the 'implements' keyword and is followed by a
 * comma separated list of the interface names ('Character') the type extends. This [Node] represents that whole
 * extension definition sequence. The [name] property represents the name of the interface being extended. The
 * [interfaces] property represents the list of interfaces being extended. The [fields] property represents the fields
 * that are provided on the type extending the interfaces. The [directives] property represents the directives on this
 * interface extension.
 *
 * Note that the definition of an interface is represented by the [InterfaceTypeDefinitionNode].
 */
data class InterfaceTypeExtensionNode(
        override val location: Location? = null,
        val name: NameNode,
        val interfaces: List<NamedTypeNode> = emptyList(),
        val directives: List<DirectiveNode> = emptyList(),
        val fields: List<FieldDefinitionNode> = emptyList()
) : BaseNode(kind = Kind.INTERFACE_TYPE_EXTENSION),
        TypeExtensionNode {

    override val childNodes: List<Node> = listOf(name) + interfaces + directives + fields
}