package com.chrynan.graphkl.language.node

import com.chrynan.graphkl.language.Kind
import com.chrynan.graphkl.language.Location
import com.chrynan.graphkl.language.Source

/**
 * A [Node] that represents an input value definition in a GraphQL Schema from a [Source]. An input value definition is
 * a defined input that can be passed in as an argument, such as to a field, or in an input object. This is the input
 * type definition and does not represent the actual value passed in with a query. The [name] property represents the
 * name of this input value. The [type] property represents the type of this input value. The [defaultValue] property
 * represents the default value, if any, of the input value.
 */
data class InputValueDefinitionNode(
        override val location: Location? = null,
        val description: StringValueNode? = null,
        val name: NameNode,
        val type: TypeNode,
        val defaultValue: ValueNode<Any?>? = null,
        val directives: List<DirectiveNode> = emptyList()
) : BaseNode(kind = Kind.INPUT_VALUE_DEFINITION)