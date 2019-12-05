package com.chrynan.graphkl.language.node

import com.chrynan.graphkl.language.Kind
import com.chrynan.graphkl.language.Location
import com.chrynan.graphkl.language.Source

/**
 * A [Node] that represents an enum value definition in a GraphQL Schema from a [Source]. For example, consider the
 * following GraphQL Schema:
 *
 * enum Episode {
 *     NEW_HOPE
 *     EMPIRE
 *     JEDI
 * }
 *
 * In the above GraphQL, there is an enum type definition for an enum named 'Episode'. This enum has three value
 * definitions: 'NEW_HOPE', 'EMPIRE', and 'JEDI'. An enum value definition consists of the enum value name and
 * optionally a description and directives. This [Node] represents that whole enum value definition sequence. The [name]
 * property represents the name of the enum value ('NEW_HOPE').
 *
 * Note that this does not define the whole enum definition. That is handled by the [EnumTypeDefinitionNode]. Also, this
 * does not represent an enum value used in a query, such as an argument parameter. That is handled by the
 * [EnumValueNode].
 */
data class EnumValueDefinitionNode(
        override val location: Location? = null,
        val description: StringValueNode? = null,
        val name: NameNode,
        val directives: List<DirectiveNode> = emptyList()
) : BaseNode(kind = Kind.ENUM_VALUE_DEFINITION) {

    override val childNodes: List<Node> = listOfNotNull(name, description) + directives
}