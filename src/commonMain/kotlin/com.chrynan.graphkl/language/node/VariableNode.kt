package com.chrynan.graphkl.language.node

import com.chrynan.graphkl.language.Kind
import com.chrynan.graphkl.language.Location
import com.chrynan.graphkl.language.Source

/**
 * A [Node] representing a GraphQL variable in a [Source]. The [name] property represents the name of this variable,
 * and the optional [value] property represents the value for the variable. Note that the variable may not be assigned
 * a value in the [Source] and therefore will but null. For more information see the KDoc for the
 * [VariableDefinitionNode] class.
 */
data class VariableNode(
        override val location: Location? = null,
        val name: NameNode,
        override val value: Any? = null
) : BaseNode(kind = Kind.VARIABLE),
        ValueNode<Any?>