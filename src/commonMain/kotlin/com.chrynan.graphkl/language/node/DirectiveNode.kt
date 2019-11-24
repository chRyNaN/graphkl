package com.chrynan.graphkl.language.node

import com.chrynan.graphkl.language.Kind
import com.chrynan.graphkl.language.Location

data class DirectiveNode(
        override val location: Location? = null,
        val name: NameNode,
        val arguments: List<ArgumentNode> = emptyList()
) : BaseNode(kind = Kind.DIRECTIVE)