package com.chrynan.graphkl.language.node

import com.chrynan.graphkl.language.Kind
import com.chrynan.graphkl.language.Location

class DocumentNode(
        override val location: Location? = null,
        val value: String
) : Node {

    override val kind: Kind = Kind.DOCUMENT
}