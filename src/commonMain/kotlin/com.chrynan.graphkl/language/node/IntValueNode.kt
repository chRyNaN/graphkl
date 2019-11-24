package com.chrynan.graphkl.language.node

import com.chrynan.graphkl.language.Kind
import com.chrynan.graphkl.language.Location

data class IntValueNode(
        override val location: Location? = null,
        override val value: Int
) : BaseNode(kind = Kind.INT),
        ValueNode<Int>