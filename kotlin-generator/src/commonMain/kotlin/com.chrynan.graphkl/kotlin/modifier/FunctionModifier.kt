package com.chrynan.graphkl.kotlin.modifier

enum class FunctionModifier(override val keyword: ModifierKeyword) : Modifier {

    ABSTRACT(keyword = ModifierKeyword.ABSTRACT),
    ACTUAL(keyword = ModifierKeyword.ACTUAL),
    EXPECT(keyword = ModifierKeyword.EXPECT),
    EXTERNAL(keyword = ModifierKeyword.EXTERNAL),
    FINAL(keyword = ModifierKeyword.FINAL),
    INFIX(keyword = ModifierKeyword.INFIX),
    INLINE(keyword = ModifierKeyword.INLINE),
    OPEN(keyword = ModifierKeyword.OPEN),
    OPERATOR(keyword = ModifierKeyword.OPERATOR),
    OVERRIDE(keyword = ModifierKeyword.OVERRIDE),
    SUSPEND(keyword = ModifierKeyword.SUSPEND),
    TAIL_REC(keyword = ModifierKeyword.TAIL_REC)
}