package com.chrynan.graphkl.language.node

import com.chrynan.graphkl.language.Kind
import com.chrynan.graphkl.language.Location

data class ArgumentNode(
        override val location: Location? = null,
        val name: NameNode,
        val value: ValueNode<Any?>
) : BaseNode(kind = Kind.ARGUMENT)