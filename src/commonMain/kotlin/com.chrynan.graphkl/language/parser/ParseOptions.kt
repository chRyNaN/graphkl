package com.chrynan.graphkl.language.parser

class ParseOptions(
        val noLocation: Boolean? = null,
        val allowLegacySDLEmptyFields: Boolean? = null,
        val allowLegacySDLImplementsInterfaces: Boolean? = null,
        val experimentalFragmentVariables: Boolean? = null
)