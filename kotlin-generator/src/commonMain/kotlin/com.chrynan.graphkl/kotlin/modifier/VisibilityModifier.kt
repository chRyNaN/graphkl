package com.chrynan.graphkl.kotlin.modifier

enum class VisibilityModifier(override val keyword: ModifierKeyword) : Modifier {

    PUBLIC(keyword = ModifierKeyword.PUBLIC),
    PRIVATE(keyword = ModifierKeyword.PRIVATE),
    INTERNAL(keyword = ModifierKeyword.INTERNAL),
    PROTECTED(keyword = ModifierKeyword.PROTECTED)
}