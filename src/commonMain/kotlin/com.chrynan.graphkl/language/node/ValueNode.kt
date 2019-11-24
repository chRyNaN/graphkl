package com.chrynan.graphkl.language.node

interface ValueNode<T> : Node {

    val value: T
}