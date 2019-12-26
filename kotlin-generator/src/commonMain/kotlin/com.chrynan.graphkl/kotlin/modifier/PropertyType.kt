package com.chrynan.graphkl.kotlin.modifier

enum class PropertyType(val keyword: Keyword) {

    VAL(keyword = HardKeyword.VAL),
    VAR(keyword = HardKeyword.VAR)
}