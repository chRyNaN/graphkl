package com.chrynan.graphkl.language.lexer

import com.chrynan.graphkl.language.Source
import com.chrynan.graphkl.language.token.Token
import com.chrynan.graphkl.language.token.TokenKind
import com.chrynan.graphkl.language.token.TokenResult

class Lexer(val source: Source) {

    val currentToken: Token
        get() = token

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
    private var line = 1
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