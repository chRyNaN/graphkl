package com.chrynan.graphkl.kotlin.modifier

enum class ModifierKeyword(override val value: String) : Keyword {

    ACTUAL(value = "actual"),
    ABSTRACT(value = "abstract"),
    ANNOTATION(value = "annotation"),
    COMPANION(value = "companion"),
    CONST(value = "const"),
    CROSS_INLINE(value = "crossinline"),
    DATA(value = "data"),
    ENUM(value = "enum"),
    EXPECT(value = "expect"),
    EXTERNAL(value = "external"),
    FINAL(value = "final"),
    INFIX(value = "infix"),
    INLINE(value = "inline"),
    INNER(value = "inner"),
    INTERNAL(value = "internal"),
    LATE_INIT(value = "lateinit"),
    NO_INLINE(value = "noinline"),
    OPEN(value = "open"),
    OPERATOR(value = "operator"),
    OUT(value = "out"),
    OVERRIDE(value = "override"),
    PRIVATE(value = "private"),
    PROTECTED(value = "protected"),
    PUBLIC(value = "public"),
    REIFIED(value = "reified"),
    SEALED(value = "sealed"),
    SUSPEND(value = "suspend"),
    TAIL_REC(value = "tailrec"),
    VARARG(value = "vararg")
}