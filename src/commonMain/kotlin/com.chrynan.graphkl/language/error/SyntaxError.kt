package com.chrynan.graphkl.language.error

import com.chrynan.graphkl.language.Source

class SyntaxError(message: String? = null, position: Int, source: Source) : RuntimeException("Syntax Error: message = $message; position = $position; source = $source")