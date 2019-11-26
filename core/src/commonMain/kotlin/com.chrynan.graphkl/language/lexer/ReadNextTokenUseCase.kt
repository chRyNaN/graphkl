package com.chrynan.graphkl.language.lexer

import com.chrynan.graphkl.language.*
import com.chrynan.graphkl.language.error.SyntaxError
import com.chrynan.graphkl.language.token.Token
import com.chrynan.graphkl.language.token.TokenKind
import com.chrynan.graphkl.language.token.TokenResult
import com.chrynan.graphkl.utils.getCharCodeAt

class ReadNextTokenUseCase(
        private val readBlockString: ReadBlockStringTokenUseCase,
        private val readComment: ReadCommentTokenUseCase,
        private val readNumber: ReadNumberTokenUseCase,
        private val readString: ReadStringTokenUseCase,
        private val readName: ReadNameTokenUseCase,
        private val getPositionAfterWhitespace: GetPositionAfterWhitespaceUseCase
) {

    operator fun invoke(source: Source, start: Int, line: Int, lineStart: Int, previous: Token): TokenResult {
        val body = source.body
        val bodyLength = body.length
        val positionResult = getPositionAfterWhitespace(body = body, start = start, line = line, lineStart = lineStart)
        val startAfterSpace = positionResult.position
        val columnAfterSpace = positionResult.lexerColumn
        val lineAfterSpace = positionResult.lexerLine
        val lineStartAfterSpace = positionResult.lexerLineStart

        if (startAfterSpace >= bodyLength) {
            val token = Token(kind = TokenKind.EOF, start = bodyLength, end = bodyLength, line = lineAfterSpace, column = columnAfterSpace, previous = previous)

            return TokenResult(token = token, lexerLine = lineAfterSpace, lexerLineStart = lineStartAfterSpace)
        }

        var result: TokenResult? = null

        val token = when (val charCode = body.getCharCodeAt(index = startAfterSpace)) {
            Bang -> Token(kind = TokenKind.BANG, start = startAfterSpace, end = startAfterSpace + 1, line = lineAfterSpace, column = columnAfterSpace, previous = previous)
            HashTag -> readComment(source = source, start = startAfterSpace, line = lineAfterSpace, column = columnAfterSpace, previous = previous)
            Dollar -> Token(kind = TokenKind.DOLLAR, start = startAfterSpace, end = startAfterSpace + 1, line = lineAfterSpace, column = columnAfterSpace, previous = previous)
            Amp -> Token(kind = TokenKind.AMP, start = startAfterSpace, end = startAfterSpace + 1, line = lineAfterSpace, column = columnAfterSpace, previous = previous)
            ParenL -> Token(kind = TokenKind.PAREN_L, start = startAfterSpace, end = startAfterSpace + 1, line = lineAfterSpace, column = columnAfterSpace, previous = previous)
            ParenR -> Token(kind = TokenKind.PAREN_R, start = startAfterSpace, end = startAfterSpace + 1, line = lineAfterSpace, column = columnAfterSpace, previous = previous)
            Colon -> Token(kind = TokenKind.COLON, start = startAfterSpace, end = startAfterSpace + 1, line = lineAfterSpace, column = columnAfterSpace, previous = previous)
            Equals -> Token(kind = TokenKind.EQUALS, start = startAfterSpace, end = startAfterSpace + 1, line = lineAfterSpace, column = columnAfterSpace, previous = previous)
            At -> Token(kind = TokenKind.AT, start = startAfterSpace, end = startAfterSpace + 1, line = lineAfterSpace, column = columnAfterSpace, previous = previous)
            BracketL -> Token(kind = TokenKind.BRACKET_L, start = startAfterSpace, end = startAfterSpace + 1, line = lineAfterSpace, column = columnAfterSpace, previous = previous)
            BracketR -> Token(kind = TokenKind.BRACKET_R, start = startAfterSpace, end = startAfterSpace + 1, line = lineAfterSpace, column = columnAfterSpace, previous = previous)
            BraceL -> Token(kind = TokenKind.BRACE_L, start = startAfterSpace, end = startAfterSpace + 1, line = lineAfterSpace, column = columnAfterSpace, previous = previous)
            BraceR -> Token(kind = TokenKind.BRACE_R, start = startAfterSpace, end = startAfterSpace + 1, line = lineAfterSpace, column = columnAfterSpace, previous = previous)
            Pipeline -> Token(kind = TokenKind.PIPE, start = startAfterSpace, end = startAfterSpace + 1, line = lineAfterSpace, column = columnAfterSpace, previous = previous)
            is CapitalAToZ,
            is LowercaseAToZ -> readName(source = source, start = startAfterSpace, line = lineAfterSpace, column = columnAfterSpace, previous = previous)
            is Digits -> readNumber(source = source, start = startAfterSpace, line = lineAfterSpace, column = columnAfterSpace, previous = previous, firstCode = charCode)
            is Quote -> {
                if (body.getCharCodeAt(index = startAfterSpace + 1) is Quote && body.getCharCodeAt(index = startAfterSpace + 2) is Quote) {
                    result = readBlockString(source = source, start = startAfterSpace, line = lineAfterSpace, column = columnAfterSpace, previous = previous, lineStart = lineStartAfterSpace)

                    result.token
                } else {
                    readString(source = source, start = startAfterSpace, line = lineAfterSpace, column = columnAfterSpace, previous = previous)
                }
            }
            Period -> {
                if (body.getCharCodeAt(index = startAfterSpace + 1) == Period && body.getCharCodeAt(index = startAfterSpace + 2) == Period) {
                    Token(kind = TokenKind.SPREAD, start = startAfterSpace, end = startAfterSpace + 3, line = lineAfterSpace, column = columnAfterSpace, previous = previous)
                } else {
                    throw SyntaxError(source = source, position = startAfterSpace, message = null)
                }
            }
            else -> throw SyntaxError(source = source, position = startAfterSpace, message = null)
        }

        return TokenResult(token = token, lexerLine = result?.lexerLine
                ?: lineAfterSpace, lexerLineStart = result?.lexerLineStart
                ?: lineStartAfterSpace)
    }
}