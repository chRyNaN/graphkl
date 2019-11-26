package com.chrynan.graphkl.language.node

import com.chrynan.graphkl.language.Kind
import com.chrynan.graphkl.language.Location
import com.chrynan.graphkl.language.Source

/**
 * A [Node] that represents a custom GraphQL scalar definition in a Schema from a [Source]. The following is an example
 * of a custom scalar definition:
 *
 * scalar Date
 *
 * A scalar definition begins with the 'scalar' keyword and is followed by the scalar name ('Date'). This [Node]
 * represents that whole definition sequence. The [name] property represents the name of the scalar ('Date').
 */
data class ScalarTypeDefinitionNode(
        override val location: Location? = null,
        val description: StringValueNode? = null,
        val name: NameNode,
        val directives: List<DirectiveNode> = emptyList()
) : BaseNode(kind = Kind.SCALAR_TYPE_DEFINITION),
        TypeDefinitionNode