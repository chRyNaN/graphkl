package com.chrynan.graphkl.kotlin

import com.chrynan.graphkl.kotlin.modifier.HardKeyword
import com.chrynan.graphkl.kotlin.modifier.Keyword

enum class PropertyType(val keyword: Keyword) {

    VAL(keyword = HardKeyword.VAL),
    VAR(keyword = HardKeyword.VAR)
}