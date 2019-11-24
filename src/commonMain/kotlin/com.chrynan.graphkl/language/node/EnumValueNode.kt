package com.chrynan.graphkl.language.node

import com.chrynan.graphkl.language.Kind
import com.chrynan.graphkl.language.Location

data class EnumValueNode(
        override val location: Location? = null,
        override val value: String
) : BaseNode(kind = Kind.ENUM),
        ValueNode<String>