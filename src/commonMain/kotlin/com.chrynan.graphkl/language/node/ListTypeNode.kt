package com.chrynan.graphkl.language.node

import com.chrynan.graphkl.language.Kind
import com.chrynan.graphkl.language.Location

data class ListTypeNode(
        override val location: Location? = null,
        val type: TypeNode
) : BaseNode(kind = Kind.LIST_TYPE),
        TypeNode