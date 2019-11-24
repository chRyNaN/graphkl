package com.chrynan.graphkl.language.node

import com.chrynan.graphkl.language.Kind
import com.chrynan.graphkl.language.Location

class NullValueNode(
        override val location: Location? = null
) : Node,
        ValueNode<Nothing?> {

    override val kind: Kind = Kind.NULL

    override val value: Nothing? = null
}