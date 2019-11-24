package com.chrynan.graphkl.language.node

import com.chrynan.graphkl.language.Kind
import com.chrynan.graphkl.language.Location

class StringValueNode(
        override val location: Location? = null,
        override val value: String,
        val block: Boolean = false
) : Node,
        ValueNode<String> {

    override val kind: Kind = Kind.STRING
}