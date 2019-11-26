package com.chrynan.graphkl.language.node

import com.chrynan.graphkl.language.Source

/**
 * A [Node] interface that represents the use of a GraphQL fragment in a Query from a [Source]. The use of a fragment
 * begins with the spread operator ('...') followed by either the name of the fragment type defined by a
 * [FragmentSpreadNode] or an inline fragment defined by an [InlineFragmentNode]. This interface is useful for scoping.
 */
interface FragmentNode : Node