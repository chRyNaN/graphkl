package com.chrynan.graphkl.language.node

import com.chrynan.graphkl.language.Kind
import com.chrynan.graphkl.language.Location

data class SelectionSetNode(
        override val location: Location? = null,
        val selections: List<SelectionNode> = emptyList()
) : BaseNode(kind = Kind.SELECTION_SET)