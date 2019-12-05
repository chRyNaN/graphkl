package com.chrynan.graphkl.language.node

import com.chrynan.graphkl.language.Kind
import com.chrynan.graphkl.language.Location

/**
 * A [Node] that contains a collection of [SelectionNode]s. A [SelectionNode] represents a "Selection".
 * "Selections" are the definitions that can appear legally and at
 * single level of the query. These include:
 * 1) field references e.g "a"
 * 2) fragment "spreads" e.g. "...c"
 * 3) inline fragment "spreads" e.g. "...on Type { a }"
 */
data class SelectionSetNode(
        override val location: Location? = null,
        val selections: List<SelectionNode> = emptyList()
) : BaseNode(kind = Kind.SELECTION_SET) {

    override val childNodes: List<Node> = selections
}