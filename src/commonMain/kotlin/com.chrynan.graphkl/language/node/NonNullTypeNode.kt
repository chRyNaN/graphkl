package com.chrynan.graphkl.language.node

import com.chrynan.graphkl.language.Kind
import com.chrynan.graphkl.language.Location

data class NonNullTypeNode(
        override val location: Location? = null,
        val type: NamedTypeNode
) : BaseNode(kind = Kind.NON_NULL_TYPE),
        TypeNode