package com.chrynan.graphkl.utils

import com.chrynan.graphkl.language.type.GraphQLRootTypeNode
import com.chrynan.graphkl.language.type.GraphQLType
import com.chrynan.graphkl.language.type.GraphQLTypeNode
import com.chrynan.graphkl.language.type.schema.GraphQLSchema

fun traverse(startWith: GraphQLTypeNode, operation: (GraphQLTypeNode) -> Unit) {
    val nodes = mutableListOf(startWith)

    while (nodes.isNotEmpty()) {
        val node = nodes.removeAt(0)

        for (child in node.childTypeNodes) {
            nodes.add(child)
        }

        operation.invoke(node)
    }
}

fun <R : GraphQLRootTypeNode> R.traverse(operation: (GraphQLTypeNode) -> Unit) = traverse(startWith = this, operation = operation)

inline fun <reified T : GraphQLType> GraphQLSchema.reduceType(): Set<T> {
    val typeSet = mutableSetOf<T>()

    traverse {
        if (it is T) {
            typeSet.add(it)
        }
    }

    return typeSet
}