package com.chrynan.graphkl.kotlin.modifier

enum class SoftKeyword(override val value: String) : Keyword {

    BY(value = "by"),
    CATCH(value = "catch"),
    CONSTRUCTOR(value = "constructor"),
    DELEGATE(value = "delegate"),
    DYNAMIC(value = "dynamic"),
    FIELD(value = "field"),
    FILE(value = "file"),
    FINALLY(value = "finally"),
    GET(value = "get"),
    IMPORT(value = "import"),
    INIT(value = "init"),
    PARAM(value = "param"),
    PROPERTY(value = "property"),
    RECEIVER(value = "receiver"),
    SET(value = "set"),
    SET_PARAM(value = "setparam"),
    WHERE(value = "where")
}