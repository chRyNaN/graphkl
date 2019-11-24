package com.chrynan.graphkl.language.node

import com.chrynan.graphkl.language.Kind
import com.chrynan.graphkl.language.Location

class IntValueNode(
        override val location: Location? = null,
        override val value: Int
) : Node,
        ValueNode<Int> {

    override val kind: Kind = Kind.INT
}