package com.chrynan.graphkl.language.visitor

import com.chrynan.graphkl.language.node.*

interface TypeExtensionVisitor {

    fun visitEnumTypeExtension(node: EnumTypeExtensionNode) {}

    fun visitInputObjectTypeExtension(node: InputObjectTypeExtensionNode) {}

    fun visitInterfaceTypeExtension(node: InterfaceTypeExtensionNode) {}

    fun visitObjectTypeExtension(node: ObjectTypeExtensionNode) {}

    fun visitScalarTypeExtension(node: ScalarTypeExtensionNode) {}

    fun visitUnionTypeExtension(node: UnionTypeExtensionNode) {}
}