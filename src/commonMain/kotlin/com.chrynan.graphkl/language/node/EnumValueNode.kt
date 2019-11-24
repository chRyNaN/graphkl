package com.chrynan.graphkl.language.node

import com.chrynan.graphkl.language.Kind
import com.chrynan.graphkl.language.Location

class EnumValueNode(
        override val location: Location? = null,
        override val value: String
) : Node,
        ValueNode<String> {

    override val kind: Kind = Kind.ENUM
}