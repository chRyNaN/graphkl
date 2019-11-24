package com.chrynan.graphkl.language.node

import com.chrynan.graphkl.language.Kind
import com.chrynan.graphkl.language.Location
import com.chrynan.graphkl.language.Source

/**
 * A [Node] representing a GraphQL union type definition within a Schema from a [Source]. For example, consider the
 * following definition:
 *
 * union SearchResult = Human | Droid | Starship
 *
 * The above is a union type definition. A union type definition begins with the 'union' keyword, followed by the name
 * of the union ('SearchResult'), then the equals character ('='), and finally the types that the union represents
 * separated by the pipeline character ('|'). This [Node] represents the whole definition sequence. The [name] property
 * represents the name of the union ('SearchResult'). The [types] property represents the types this union represents
 * ('Human', 'Droid', and 'Starship').
 *
 * Note that a union type can be extended, similar to an interface type, which is represented by
 * [UnionTypeExtensionNode].
 */
data class UnionTypeDefinitionNode(
        override val location: Location? = null,
        val description: StringValueNode? = null,
        val name: NameNode,
        val directives: List<DirectiveNode> = emptyList(),
        val types: List<NamedTypeNode> = emptyList()
) : BaseNode(kind = Kind.UNION_TYPE_DEFINITION),
        TypeDefinitionNode