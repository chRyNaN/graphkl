package com.chrynan.graphkl.language.node

import com.chrynan.graphkl.language.Kind
import com.chrynan.graphkl.language.Location

data class StringValueNode(
        override val location: Location? = null,
        override val value: String,
        val block: Boolean = false
) : BaseNode(kind = Kind.STRING),
        ValueNode<String>