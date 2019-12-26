package com.chrynan.graphkl.kotlin.modifier

enum class ClassModifier(override val keyword: ModifierKeyword) : Modifier {

    ABSTRACT(keyword = ModifierKeyword.ABSTRACT),
    ACTUAL(keyword = ModifierKeyword.ACTUAL),
    ANNOTATION(keyword = ModifierKeyword.ANNOTATION),
    DATA(keyword = ModifierKeyword.DATA),
    ENUM(keyword = ModifierKeyword.ENUM),
    EXPECT(keyword = ModifierKeyword.EXPECT),
    EXTERNAL(keyword = ModifierKeyword.EXTERNAL),
    FINAL(keyword = ModifierKeyword.FINAL),
    INNER(keyword = ModifierKeyword.INNER),
    OPEN(keyword = ModifierKeyword.OPEN),
    SEALED(keyword = ModifierKeyword.SEALED)
}