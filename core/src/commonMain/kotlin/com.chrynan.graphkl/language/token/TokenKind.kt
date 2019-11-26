package com.chrynan.graphkl.language.token

enum class TokenKind(val value: String) {

    SOF(value = "<SOF>"),
    EOF(value = "<EOF>"),
    BANG(value = "!"),
    DOLLAR(value = "$"),
    AMP(value = "&"),
    PAREN_L(value = "("),
    PAREN_R(value = ")"),
    SPREAD(value = "..."),
    COLON(value = ":"),
    EQUALS(value = "="),
    AT(value = "@"),
    BRACKET_L(value = "["),
    BRACKET_R(value = "]"),
    PIPE(value = "|"),
    BRACE_L(value = "{"),
    BRACE_R(value = "}"),
    NAME(value = "Name"),
    INT(value = "Int"),
    FLOAT(value = "Float"),
    STRING(value = "String"),
    BLOCK_STRING(value = "BlockString"),
    COMMENT(value = "Comment");

    val isPunctuator: Boolean
        get() = when (this) {
            BANG,
            DOLLAR,
            AMP,
            PAREN_L,
            PAREN_R,
            SPREAD,
            COLON,
            EQUALS,
            AT,
            BRACKET_L,
            BRACKET_R,
            BRACE_L,
            BRACE_R,
            PIPE -> true
            else -> false
        }
}