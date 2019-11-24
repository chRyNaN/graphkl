package com.chrynan.graphkl.language.node

import com.chrynan.graphkl.language.Kind

/**
 * A base abstract class implementing the [Node] interface. This abstract class takes in the overriden [kind] property
 * of the [Node] interface as a parameter. This allows for syntactically nicer extension of the [Node] interface for all
 * nodes in the parse tree.
 */
abstract class BaseNode(override val kind: Kind) : Node