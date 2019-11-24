package com.chrynan.graphkl.language.node

import com.chrynan.graphkl.language.Kind
import com.chrynan.graphkl.language.Location

data class FloatValueNode(
        override val location: Location? = null,
        override val value: Float
) : BaseNode(kind = Kind.FLOAT),
        ValueNode<Float>