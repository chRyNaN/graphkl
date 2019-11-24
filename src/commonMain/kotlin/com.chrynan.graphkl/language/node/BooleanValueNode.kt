package com.chrynan.graphkl.language.node

import com.chrynan.graphkl.language.Kind
import com.chrynan.graphkl.language.Location

data class BooleanValueNode(
        override val location: Location? = null,
        override val value: Boolean
) : BaseNode(kind = Kind.BOOLEAN),
        ValueNode<Boolean>