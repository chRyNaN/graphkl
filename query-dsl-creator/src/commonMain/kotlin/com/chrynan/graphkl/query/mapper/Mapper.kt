package com.chrynan.graphkl.query.mapper

interface Mapper<IN, OUT> {

    fun map(model: IN): OUT
}