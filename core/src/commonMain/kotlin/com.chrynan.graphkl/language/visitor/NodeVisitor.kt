package com.chrynan.graphkl.language.visitor

import com.chrynan.graphkl.language.node.*

interface NodeVisitor : ValueNodeVisitor,
        TypeDefinitionVisitor,
        TypeExtensionVisitor,
        TypeVisitor,
        SchemaVisitor {

    fun visitArgument(node: ArgumentNode) {}

    fun visitDirectiveDefinition(node: DirectiveDefinitionNode) {}

    fun visitDirective(node: DirectiveNode) {}

    fun visitEnumValueDefinition(node: EnumValueDefinitionNode) {}

    fun visitFieldDefinition(node: FieldDefinitionNode) {}

    fun visitField(node: FieldNode) {}

    fun visitFragmentDefinition(node: FragmentDefinitionNode) {}

    fun visitFragmentSpread(node: FragmentSpreadNode) {}

    fun visitInlineFragment(node: InlineFragmentNode) {}

    fun visitInputValueDefinition(node: InputValueDefinitionNode) {}

    fun visitName(node: NameNode) {}

    fun visitObjectField(node: ObjectFieldNode) {}

    fun visitOperationDefinition(node: OperationDefinitionNode) {}

    fun visitOperationTypeDefinition(node: OperationTypeDefinitionNode) {}

    fun visitSelectionSet(node: SelectionSetNode) {}

    fun visitVariableDefinition(node: VariableDefinitionNode) {}
}