package com.chrynan.graphkl.language.visitor

import com.chrynan.graphkl.language.node.ListTypeNode
import com.chrynan.graphkl.language.node.NamedTypeNode
import com.chrynan.graphkl.language.node.NonNullTypeNode

interface TypeVisitor {

    fun visitListType(node: ListTypeNode) {}

    fun visitNamedType(node: NamedTypeNode) {}

    fun visitNonNullType(node: NonNullTypeNode) {}
}