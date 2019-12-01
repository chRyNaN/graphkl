package com.chrynan.graphkl.language.visitor

import com.chrynan.graphkl.language.node.*

interface TypeDefinitionVisitor {

    fun visitEnumTypeDefinition(node: EnumTypeDefinitionNode) {}

    fun visitInputObjectTypeDefinition(node: InputObjectTypeDefinitionNode) {}

    fun visitInterfaceTypeDefinition(node: InterfaceTypeDefinitionNode) {}

    fun visitObjectTypeDefinition(node: ObjectTypeDefinitionNode) {}

    fun visitScalarTypeDefinition(node: ScalarTypeDefinitionNode) {}

    fun visitUnionTypeDefinition(node: UnionTypeDefinitionNode) {}
}