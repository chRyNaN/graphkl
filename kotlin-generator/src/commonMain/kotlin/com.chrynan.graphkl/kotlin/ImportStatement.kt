package com.chrynan.graphkl.kotlin

data class ImportStatement(
        val fullName: String,
        val alias: String? = null
) {

    override fun toString() = buildString {
        append("import $fullName")

        if (alias != null) {
            append(" as $alias")
        }
    }
}