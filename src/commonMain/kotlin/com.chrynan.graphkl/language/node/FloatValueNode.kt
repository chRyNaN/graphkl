package com.chrynan.graphkl.language.node

import com.chrynan.graphkl.language.Kind
import com.chrynan.graphkl.language.Location

class FloatValueNode(
        override val location: Location? = null,
        override val value: Float
) : Node,
        ValueNode<Float> {

    override val kind: Kind = Kind.FLOAT
}