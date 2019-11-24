package com.chrynan.graphkl.language.node

import com.chrynan.graphkl.language.Kind
import com.chrynan.graphkl.language.Location

interface Node {

    val kind: Kind
    val location: Location?
}