package com.chrynan.graphkl.language.node

import com.chrynan.graphkl.language.Kind
import com.chrynan.graphkl.language.Location

/**
 * Represents a node in a parse tree. This is the base interface for all nodes of the parse tree.
 */
interface Node {

    val kind: Kind
    val location: Location?
    val childNodes: List<Node>
}