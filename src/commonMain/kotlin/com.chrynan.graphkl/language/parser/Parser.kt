package com.chrynan.graphkl.language.parser

import com.chrynan.graphkl.language.Source
import com.chrynan.graphkl.language.lexer.Lexer
import com.chrynan.graphkl.language.node.DocumentNode
import com.chrynan.graphkl.language.node.TypeNode
import com.chrynan.graphkl.language.node.ValueNode

class Parser {

    private val source: Source
    private val options: ParseOptions
    private val lexer: Lexer

    constructor(source: String, options: ParseOptions = ParseOptions()) {
        this.source = Source(source)
        this.options = options
        this.lexer = Lexer(source = this.source)
    }

    constructor(source: Source, options: ParseOptions = ParseOptions()) {
        this.source = source
        this.options = options
        this.lexer = Lexer(source = source)
    }

    /**
     * Given a GraphQL source, parses it into a Document.
     * Throws GraphQLError if a syntax error is encountered.
     */
    fun parse(): DocumentNode = TODO()

    /**
     * Given a string containing a GraphQL value (ex. `[42]`), parse the AST for
     * that value.
     * Throws GraphQLError if a syntax error is encountered.
     *
     * This is useful within tools that operate upon GraphQL Values directly and
     * in isolation of complete GraphQL documents.
     *
     * Consider providing the results to the utility function: valueFromAST().
     */
    fun <T> parseValue(): ValueNode<T> = TODO()

    /**
     * Given a string containing a GraphQL Type (ex. `[Int!]`), parse the AST for
     * that type.
     * Throws GraphQLError if a syntax error is encountered.
     *
     * This is useful within tools that operate upon GraphQL Types directly and
     * in isolation of complete GraphQL documents.
     *
     * Consider providing the results to the utility function: typeFromAST().
     */
    fun parseType(): TypeNode = TODO()
}