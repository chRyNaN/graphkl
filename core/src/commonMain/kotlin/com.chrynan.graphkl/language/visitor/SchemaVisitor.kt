package com.chrynan.graphkl.language.visitor

import com.chrynan.graphkl.language.node.SchemaDefinitionNode
import com.chrynan.graphkl.language.node.SchemaExtensionNode

interface SchemaVisitor {

    fun visitSchemaDefinition(node: SchemaDefinitionNode) {}

    fun visitSchemaExtension(node: SchemaExtensionNode) {}
}