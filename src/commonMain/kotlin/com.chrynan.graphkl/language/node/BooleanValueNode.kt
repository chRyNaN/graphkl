package com.chrynan.graphkl.language.node

import com.chrynan.graphkl.language.Kind
import com.chrynan.graphkl.language.Location

class BooleanValueNode(
        override val location: Location? = null,
        override val value: Boolean
) : Node,
        ValueNode<Boolean> {

    override val kind: Kind = Kind.BOOLEAN
}