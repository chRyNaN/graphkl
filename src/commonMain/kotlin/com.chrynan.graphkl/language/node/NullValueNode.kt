package com.chrynan.graphkl.language.node

import com.chrynan.graphkl.language.Kind
import com.chrynan.graphkl.language.Location
import com.chrynan.graphkl.language.Source

/**
 * A [Node] representing a 'null' value from a [Source]. This is [ValueNode] whose value is always 'null'.
 */
data class NullValueNode(
        override val location: Location? = null
) : BaseNode(kind = Kind.NULL),
        ValueNode<Nothing?> {

    override val kind: Kind = Kind.NULL

    override val value: Nothing? = null
}