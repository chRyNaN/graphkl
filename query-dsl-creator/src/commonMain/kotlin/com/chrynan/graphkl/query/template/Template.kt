package com.chrynan.graphkl.query.template

interface Template<M : Any> {

    operator fun invoke(model: M): String
}