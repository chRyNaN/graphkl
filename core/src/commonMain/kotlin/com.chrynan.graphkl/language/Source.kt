package com.chrynan.graphkl.language

/**
 * A representation of source input to GraphQL.
 * `name` and `locationOffset` are optional. They are useful for clients who
 * store GraphQL documents in source files; for example, if the GraphQL input
 * starts at line 40 in a file named Foo.graphql, it might be useful for name to
 * be "Foo.graphql" and location to be `{ line: 40, column: 0 }`.
 * line and column in locationOffset are 1-indexed
 */
class Source(
        val body: String,
        val name: String? = null,
        val locationOffset: SourceLocation = SourceLocation(line = 1, column = 1)
)