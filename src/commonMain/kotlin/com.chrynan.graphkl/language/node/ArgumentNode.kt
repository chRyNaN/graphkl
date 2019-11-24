package com.chrynan.graphkl.language.node

import com.chrynan.graphkl.language.Kind
import com.chrynan.graphkl.language.Location

class ArgumentNode(
        override val location: Location? = null,
        val name: NameNode,
        val value: ValueNode<Any?>
) : Node {

    override val kind: Kind = Kind.ARGUMENT
}