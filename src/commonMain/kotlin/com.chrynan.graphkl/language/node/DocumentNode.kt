package com.chrynan.graphkl.language.node

import com.chrynan.graphkl.language.Kind
import com.chrynan.graphkl.language.Location

data class DocumentNode(
        override val location: Location? = null,
        val value: String,
        val definitions: List<DefinitionNode> = emptyList()
) : BaseNode(kind = Kind.DOCUMENT)