package com.chrynan.graphkl.language.node

import com.chrynan.graphkl.language.Kind
import com.chrynan.graphkl.language.Location

data class ListValueNode(
        override val location: Location? = null,
        override val value: List<ValueNode<Any?>> = emptyList()
) : BaseNode(kind = Kind.LIST),
        ValueNode<List<ValueNode<Any?>>>