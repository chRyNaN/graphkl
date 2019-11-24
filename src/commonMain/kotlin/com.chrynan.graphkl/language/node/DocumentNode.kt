package com.chrynan.graphkl.language.node

import com.chrynan.graphkl.language.Kind
import com.chrynan.graphkl.language.Location
import com.chrynan.graphkl.language.Source

/**
 * A [Node] representing the whole GraphQL Document that was parsed from a [Source]. This is a [RootNode] that
 * represents the top of the parsed tree. This [Node] contains all the Schemas and Queries within a parsed [Source]. The
 * [definitions] property contains a list of all the Schemas and Queries defined.
 */
data class DocumentNode(
        override val location: Location? = null,
        val definitions: List<DefinitionNode> = emptyList()
) : BaseNode(kind = Kind.DOCUMENT),
        RootNode