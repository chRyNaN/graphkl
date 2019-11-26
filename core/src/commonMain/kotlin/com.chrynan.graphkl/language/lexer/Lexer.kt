package com.chrynan.graphkl.language.lexer

import com.chrynan.graphkl.language.Source
import com.chrynan.graphkl.language.token.Token
import com.chrynan.graphkl.language.token.TokenKind
import com.chrynan.graphkl.language.token.TokenResult

/**
 * Given a Source object, creates a Lexer for that source.
 * A Lexer is a stateful stream generator in that every time
 * it is advanced, it returns the next token in the Source. Assuming the
 * source lexes, the final Token emitted by the lexer will be of kind
 * EOF, after which the lexer will repeatedly return the same EOF token
 * whenever called.
 */
class Lexer(val source: Source) {

    /**
     * The currently focused non-ignored token.
     */
    val currentToken: Token
        get() = token

    /**
     * The previously focused non-ignored token.
     */
    val previousToken: Token
        get() = lastToken

    private val readBlockString = ReadBlockStringTokenUseCase()
    private val readString = ReadStringTokenUseCase()
    private val readName = ReadNameTokenUseCase()
    private val readNumber = ReadNumberTokenUseCase()
    private val readComment = ReadCommentTokenUseCase()
    private val getColumnFromPosition = GetColumnFromPositionUseCase()
    private val getPositionAfterWhitespace = GetPositionAfterWhitespaceUseCase(getColumnFromPosition = getColumnFromPosition)
    private val readNextToken = ReadNextTokenUseCase(
            readBlockString = readBlockString,
            readComment = readComment,
            readName = readName,
            readNumber = readNumber,
            readString = readString,
            getPositionAfterWhitespace = getPositionAfterWhitespace)

    private var lastToken = Token(kind = TokenKind.SOF, start = 0, end = 0, line = 0, column = 0, value = null)
    private var token = Token(kind = TokenKind.SOF, start = 0, end = 0, line = 0, column = 0, value = null)
    /**
     * The (1-indexed) line containing the current token.
     */
    private var line = 1
    /**
     * The character offset at which the current line begins.
     */
    private var lineStart = 0

    /**
     * Retrieves the next [Token] from the [Source] and advances the [Lexer] position.
     */
    fun readNextToken(): Token {
        val result = readNextToken(source = source, start = lastToken.end, line = line, lineStart = lineStart, previous = lastToken)

        line = result.lexerLine
        lineStart = result.lexerLineStart
        lastToken = token
        token = result.token

        return result.token
    }

    /**
     * Retrieves the next [TokenResult] from the [Source] but keeps the [Lexer] at the current position.
     */
    fun peekNextToken(): TokenResult =
            readNextToken(source = source, start = lastToken.end, line = line, lineStart = lineStart, previous = lastToken)
}