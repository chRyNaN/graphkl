package com.chrynan.graphkl.language.visitor

import com.chrynan.graphkl.language.node.*

/**
 * Visits the provided [Node] by calling the correct [NodeVisitor] function on this [NodeVisitor] instance.
 */
fun <V : NodeVisitor> V.visit(node: Node) =
        when (node) {
            is DocumentNode -> visitDocument(node)
            is OperationDefinitionNode -> visitOperationDefinition(node)
            is VariableDefinitionNode -> visitVariableDefinition(node)
            is SchemaDefinitionNode -> visitSchemaDefinition(node)
            is SchemaExtensionNode -> visitSchemaExtension(node)
            is OperationTypeDefinitionNode -> visitOperationTypeDefinition(node)
            is FragmentDefinitionNode -> visitFragmentDefinition(node)
            is FragmentSpreadNode -> visitFragmentSpread(node)
            is InlineFragmentNode -> visitInlineFragment(node)
            is ArgumentNode -> visitArgument(node)
            is DirectiveDefinitionNode -> visitDirectiveDefinition(node)
            is DirectiveNode -> visitDirective(node)
            is NameNode -> visitName(node)
            is NamedTypeNode -> visitNamedType(node)
            is IntValueNode -> visitIntValue(node)
            is FloatValueNode -> visitFloatValue(node)
            is StringValueNode -> visitStringValue(node)
            is BooleanValueNode -> visitBooleanValue(node)
            is VariableNode -> visitVariable(node)
            is ListValueNode -> visitListValue(node)
            is NullValueNode -> visitNullValue(node)
            is ObjectValueNode -> visitObjectValue(node)
            is EnumValueNode -> visitEnumValue(node)
            is ObjectFieldNode -> visitObjectField(node)
            is EnumValueDefinitionNode -> visitEnumValueDefinition(node)
            is FieldDefinitionNode -> visitFieldDefinition(node)
            is InputValueDefinitionNode -> visitInputValueDefinition(node)
            is ListTypeNode -> visitListType(node)
            is NonNullTypeNode -> visitNonNullType(node)
            is EnumTypeExtensionNode -> visitEnumTypeExtension(node)
            is ObjectTypeExtensionNode -> visitObjectTypeExtension(node)
            is UnionTypeExtensionNode -> visitUnionTypeExtension(node)
            is ScalarTypeExtensionNode -> visitScalarTypeExtension(node)
            is InterfaceTypeExtensionNode -> visitInterfaceTypeExtension(node)
            is InputObjectTypeExtensionNode -> visitInputObjectTypeExtension(node)
            is UnionTypeDefinitionNode -> visitUnionTypeDefinition(node)
            is ObjectTypeDefinitionNode -> visitObjectTypeDefinition(node)
            is EnumTypeDefinitionNode -> visitEnumTypeDefinition(node)
            is InterfaceTypeDefinitionNode -> visitInterfaceTypeDefinition(node)
            is InputObjectTypeDefinitionNode -> visitInputObjectTypeDefinition(node)
            is ScalarTypeDefinitionNode -> visitScalarTypeDefinition(node)
            is FieldNode -> visitField(node)
            is SelectionSetNode -> visitSelectionSet(node)
            else -> Unit
        }

fun <V : NodeVisitor> V.traverseAndVisit(rootNode: RootNode) = rootNode.traverse { visit(it) }