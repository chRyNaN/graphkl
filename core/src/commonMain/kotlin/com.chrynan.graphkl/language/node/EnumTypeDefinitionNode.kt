package com.chrynan.graphkl.language.node

import com.chrynan.graphkl.language.Kind
import com.chrynan.graphkl.language.Location
import com.chrynan.graphkl.language.Source

/**
 * A [Node] that represents a GraphQL enum definition in a Schema from a [Source]. The following is an example of an
 * enum type definition:
 *
 * enum Episode {
 *     NEW_HOPE
 *     EMPIRE
 *     JEDI
 * }
 *
 * In the above GraphQL, an enum is defined with the name 'Episode' and the values: 'NEW_HOPE', 'EMPIRE', and 'JEDI'.
 * An enum definition begins with the 'enum' keyword, followed by the name of the enum ('Episode'), then brackets
 * containing the enum value names separated by new lines. This [Node] represents that whole definition sequence. The
 * [name] property represents the name of the enum ('Episode'). The [values] property represents the enum values this
 * enum contains ('NEW_HOPE', etc).
 */
data class EnumTypeDefinitionNode(
        override val location: Location? = null,
        val description: StringValueNode? = null,
        val name: NameNode,
        val directives: List<DirectiveNode> = emptyList(),
        val values: List<EnumValueDefinitionNode> = emptyList()
) : BaseNode(kind = Kind.ENUM_TYPE_DEFINITION),
        TypeDefinitionNode