package com.chrynan.graphkl.language.node

import com.chrynan.graphkl.language.Kind
import com.chrynan.graphkl.language.Location

class SelectionSetNode(
        override val location: Location? = null,
        val selections: List<SelectionNode> = emptyList()
) : Node {

    override val kind: Kind = Kind.SELECTION_SET
}