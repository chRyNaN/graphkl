package com.chrynan.graphkl.language.token

/**
 * Represents a range of characters represented by a lexical token
 * within a Source.
 */
data class Token(
        /**
         * The kind of Token.
         */
        val kind: TokenKind,
        /**
         * The character offset at which this Node begins.
         */
        val start: Int,
        /**
         * The character offset at which this Node ends.
         */
        val end: Int,
        /**
         * The 1-indexed line number on which this Token appears.
         */
        val line: Int,
        /**
         * The 1-indexed column number at which this Token begins.
         */
        val column: Int,
        /**
         * For non-punctuation tokens, represents the interpreted value of the token.
         */
        val value: String? = null,
        /**
         * Tokens exist as nodes in a double-linked-list amongst all tokens
         * including ignored tokens. <SOF> is always the first node and <EOF>
         * the last.
         */
        val previous: Token? = null
) {

    /**
     * Tokens exist as nodes in a double-linked-list amongst all tokens
     * including ignored tokens. <SOF> is always the first node and <EOF>
     * the last.
     */
    var next: Token? = null
        internal set
}