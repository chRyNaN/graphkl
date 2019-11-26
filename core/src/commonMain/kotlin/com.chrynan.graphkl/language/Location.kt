package com.chrynan.graphkl.language

import com.chrynan.graphkl.language.token.Token

/**
 * Contains a range of UTF-8 character offsets and token references that
 * identify the region of the source from which the AST derived.
 */
data class Location(
        /**
         * The Token at which this Node begins.
         */
        val startToken: Token,
        /**
         * The Token at which this Node ends.
         */
        val endToken: Token,
        /**
         * The Source document the AST represents.
         */
        val source: Source
) {

    /**
     * The character offset at which this Node begins.
     */
    val start: Int = startToken.start
    /**
     * The character offset at which this Node ends.
     */
    val end: Int = endToken.end
}