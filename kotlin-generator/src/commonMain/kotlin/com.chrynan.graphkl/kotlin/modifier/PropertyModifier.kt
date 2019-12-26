package com.chrynan.graphkl.kotlin.modifier

enum class PropertyModifier(override val keyword: ModifierKeyword) : Modifier {

    ACTUAL(keyword = ModifierKeyword.ACTUAL),
    ABSTRACT(keyword = ModifierKeyword.ABSTRACT),
    CONST(keyword = ModifierKeyword.CONST),
    EXPECT(keyword = ModifierKeyword.EXPECT),
    EXTERNAL(keyword = ModifierKeyword.EXTERNAL),
    FINAL(keyword = ModifierKeyword.FINAL),
    INLINE(keyword = ModifierKeyword.INLINE),
    LATE_INIT(keyword = ModifierKeyword.LATE_INIT),
    OPEN(keyword = ModifierKeyword.OPEN),
    OPERATOR(keyword = ModifierKeyword.OPERATOR),
    OVERRIDE(keyword = ModifierKeyword.OVERRIDE)
}