package com.chrynan.graphkl.language.visitor

import com.chrynan.graphkl.language.node.*

fun <V : NodeVisitor> V.visitAll(node: DocumentNode) = handleDocument(node)

fun <V : NodeVisitor> DocumentNode.visitAllWith(visitor: V) = visitor.handleDocument(this)

internal fun <V : NodeVisitor> V.handleDocument(node: DocumentNode) {
    visitDocument(node)
    node.definitions.forEach { handleDefinition(it) }
}

internal fun <V : NodeVisitor> V.handleOperationDefinition(node: OperationDefinitionNode) {
    visitOperationDefinition(node)
    handleName(node.name)
    handleSelectionSet(node.selectionSet)
    node.directives.forEach { handleDirective(it) }
    node.variableDefinitions.forEach { handleVariableDefinition(it) }
}

internal fun <V : NodeVisitor> V.handleVariableDefinition(node: VariableDefinitionNode) {
    visitVariableDefinition(node)
    handleType(node.type)
    handleVariableValue(node.variable)
    node.directives.forEach { handleDirective(it) }
    node.defaultValue?.let { handleValue(it) }
}

internal fun <V : NodeVisitor> V.handleDefinition(node: DefinitionNode) =
        when (node) {
            is TypeSystemDefinitionNode -> handleTypeSystemDefinition(node)
            is TypeSystemExtensionNode -> handleTypeSystemExtension(node)
            is ExecutableDefinitionNode -> handleExecutableDefinition(node)
            else -> Unit
        }

internal fun <V : NodeVisitor> V.handleTypeSystemExtension(node: TypeSystemExtensionNode) =
        when (node) {
            is SchemaExtensionNode -> handleSchemaExtension(node)
            is TypeExtensionNode -> handleTypeExtension(node)
            else -> Unit
        }

internal fun <V : NodeVisitor> V.handleTypeSystemDefinition(node: TypeSystemDefinitionNode) =
        when (node) {
            is DirectiveDefinitionNode -> handleDirectiveDefinition(node)
            is SchemaDefinitionNode -> handleSchemaDefinition(node)
            is TypeDefinitionNode -> handleTypeDefinition(node)
            else -> Unit
        }

internal fun <V : NodeVisitor> V.handleSchemaDefinition(node: SchemaDefinitionNode) {
    visitSchemaDefinition(node)
    node.directives.forEach { handleDirective(it) }
    node.operationTypes.forEach { handleOperationTypeDefinition(it) }
}

internal fun <V : NodeVisitor> V.handleOperationTypeDefinition(node: OperationTypeDefinitionNode) {
    visitOperationTypeDefinition(node)
    handleNamedType(node.type)
}

internal fun <V : NodeVisitor> V.handleExecutableDefinition(node: ExecutableDefinitionNode) =
        when (node) {
            is FragmentDefinitionNode -> handleFragmentDefinitionNode(node)
            is OperationDefinitionNode -> handleOperationDefinition(node)
            else -> Unit
        }

internal fun <V : NodeVisitor> V.handleFragmentDefinitionNode(node: FragmentDefinitionNode) {
    visitFragmentDefinition(node)
    handleName(node.name)
    handleNamedType(node.typeCondition)
    node.directives.forEach { handleDirective(it) }
    node.variableDefinitions.forEach { handleVariableDefinition(it) }
    handleSelectionSet(node.selectionSet)
}

internal fun <V : NodeVisitor> V.handleSchemaExtension(node: SchemaExtensionNode) {
    visitSchemaExtension(node)
    node.directives.forEach { handleDirective(it) }
    node.operationTypes.forEach { handleOperationTypeDefinition(it) }
}

internal fun <V : NodeVisitor> V.handleArgument(node: ArgumentNode) {
    visitArgument(node)
    handleName(node.name)
    handleValue(node.value)
}

internal fun <V : NodeVisitor> V.handleDirectiveDefinition(node: DirectiveDefinitionNode) {
    visitDirectiveDefinition(node)
    handleName(node.name)
    node.description?.let(::visitStringValue)
    node.locations.forEach { handleName(it) }
    node.arguments.forEach { handleInputValueDefinition(it) }
}

internal fun <V : NodeVisitor> V.handleDirective(node: DirectiveNode) {
    visitDirective(node)
    handleName(node.name)
    node.arguments.forEach { handleArgument(it) }
}

internal fun <V : NodeVisitor> V.handleName(node: NameNode) = visitName(node)

internal fun <V : NodeVisitor> V.handleNamedType(node: NamedTypeNode) {
    visitNamedType(node)
    handleName(node.name)
}

internal fun <V : NodeVisitor> V.handleValue(node: ValueNode<*>) =
        when (node) {
            is IntValueNode -> visitIntValue(node)
            is FloatValueNode -> visitFloatValue(node)
            is StringValueNode -> visitStringValue(node)
            is BooleanValueNode -> visitBooleanValue(node)
            is VariableNode -> handleVariableValue(node)
            is ListValueNode -> handleListValue(node)
            is NullValueNode -> visitNullValue(node)
            is ObjectValueNode -> handleObjectValue(node)
            is EnumValueNode -> visitEnumValue(node)
            else -> Unit
        }

internal fun <V : NodeVisitor> V.handleVariableValue(node: VariableNode) {
    visitVariable(node)
    handleName(node.name)
}

internal fun <V : NodeVisitor> V.handleListValue(node: ListValueNode) {
    visitListValue(node)
    node.value.forEach { handleValue(it) }
}

internal fun <V : NodeVisitor> V.handleObjectValue(node: ObjectValueNode) {
    visitObjectValue(node)
    node.value.forEach { handleObjectFieldNode(it) }
}

internal fun <V : NodeVisitor> V.handleObjectFieldNode(node: ObjectFieldNode) {
    visitObjectField(node)
    handleName(node.name)
    handleValue(node.value)
}

internal fun <V : NodeVisitor> V.handleEnumValueDefinition(node: EnumValueDefinitionNode) {
    visitEnumValueDefinition(node)
    handleName(node.name)
    node.description?.let(::visitStringValue)
    node.directives.forEach { handleDirective(it) }
}

internal fun <V : NodeVisitor> V.handleFieldDefinition(node: FieldDefinitionNode) {
    visitFieldDefinition(node)
    handleName(node.name)
    node.description?.let(::visitStringValue)
    node.directives.forEach { handleDirective(it) }
    node.arguments.forEach { handleInputValueDefinition(it) }
    handleType(node.type)
}

internal fun <V : NodeVisitor> V.handleInputValueDefinition(node: InputValueDefinitionNode) {
    visitInputValueDefinition(node)
    handleType(node.type)
    handleName(node.name)
    node.description?.let(::visitStringValue)
    node.defaultValue?.let { handleValue(it) }
    node.directives.forEach { handleDirective(it) }
}

internal fun <V : NodeVisitor> V.handleType(node: TypeNode) =
        when (node) {
            is ListTypeNode -> handleListType(node)
            is NonNullTypeNode -> handleNonNullType(node)
            is NamedTypeNode -> handleNamedType(node)
            else -> Unit
        }

internal fun <V : NodeVisitor> V.handleListType(node: ListTypeNode) {
    visitListType(node)
    handleType(node.type)
}

internal fun <V : NodeVisitor> V.handleNonNullType(node: NonNullTypeNode) {
    visitNonNullType(node)
    handleType(node.type)
}

internal fun <V : NodeVisitor> V.handleTypeExtension(node: TypeExtensionNode) =
        when (node) {
            is EnumTypeExtensionNode -> handleEnumTypeExtension(node)
            is ObjectTypeExtensionNode -> handleObjectTypeExtension(node)
            is UnionTypeExtensionNode -> handleUnionTypeExtension(node)
            is ScalarTypeExtensionNode -> handleScalarTypeExtension(node)
            is InterfaceTypeExtensionNode -> handleInterfaceTypeExtension(node)
            is InputObjectTypeExtensionNode -> handleInputObjectTypeExtension(node)
            else -> Unit
        }

internal fun <V : NodeVisitor> V.handleEnumTypeExtension(node: EnumTypeExtensionNode) {
    visitEnumTypeExtension(node)
    handleName(node.name)
    node.directives.forEach { handleDirective(it) }
    node.values.forEach { handleEnumValueDefinition(it) }
}

internal fun <V : NodeVisitor> V.handleObjectTypeExtension(node: ObjectTypeExtensionNode) {
    visitObjectTypeExtension(node)
    handleName(node.name)
    node.directives.forEach { handleDirective(it) }
    node.fields.forEach { handleFieldDefinition(it) }
    node.interfaces.forEach { handleNamedType(it) }
}

internal fun <V : NodeVisitor> V.handleUnionTypeExtension(node: UnionTypeExtensionNode) {
    visitUnionTypeExtension(node)
    handleName(node.name)
    node.directives.forEach { handleDirective(it) }
    node.types.forEach { handleNamedType(it) }
}

internal fun <V : NodeVisitor> V.handleScalarTypeExtension(node: ScalarTypeExtensionNode) {
    visitScalarTypeExtension(node)
    handleName(node.name)
    node.directives.forEach { handleDirective(it) }
}

internal fun <V : NodeVisitor> V.handleInterfaceTypeExtension(node: InterfaceTypeExtensionNode) {
    visitInterfaceTypeExtension(node)
    handleName(node.name)
    node.directives.forEach { handleDirective(it) }
    node.fields.forEach { handleFieldDefinition(it) }
    node.interfaces.forEach { handleNamedType(it) }
}

internal fun <V : NodeVisitor> V.handleInputObjectTypeExtension(node: InputObjectTypeExtensionNode) {
    visitInputObjectTypeExtension(node)
    handleName(node.name)
    node.directives.forEach { handleDirective(it) }
    node.values.forEach { handleEnumValueDefinition(it) }
}

internal fun <V : NodeVisitor> V.handleTypeDefinition(node: TypeDefinitionNode) =
        when (node) {
            is UnionTypeDefinitionNode -> handleUnionTypeDefinition(node)
            is ObjectTypeDefinitionNode -> handleObjectTypeDefinition(node)
            is EnumTypeDefinitionNode -> handleEnumTypeDefinition(node)
            is InterfaceTypeDefinitionNode -> handleInterfaceTypeDefinition(node)
            is InputObjectTypeDefinitionNode -> handleInputObjectTypeDefinition(node)
            is ScalarTypeDefinitionNode -> handleScalarTypeDefinition(node)
            else -> Unit
        }

internal fun <V : NodeVisitor> V.handleUnionTypeDefinition(node: UnionTypeDefinitionNode) {
    visitUnionTypeDefinition(node)
    handleName(node.name)
    node.description?.let(::visitStringValue)
    node.directives.forEach { handleDirective(it) }
    node.types.forEach { handleNamedType(it) }
}

internal fun <V : NodeVisitor> V.handleObjectTypeDefinition(node: ObjectTypeDefinitionNode) {
    visitObjectTypeDefinition(node)
    handleName(node.name)
    node.description?.let(::visitStringValue)
    handleType(node.type)
    node.arguments.forEach { handleInputValueDefinition(it) }
    node.directives.forEach { handleDirective(it) }
}

internal fun <V : NodeVisitor> V.handleEnumTypeDefinition(node: EnumTypeDefinitionNode) {
    visitEnumTypeDefinition(node)
    handleName(node.name)
    node.description?.let(::visitStringValue)
    node.values.forEach { handleEnumValueDefinition(it) }
    node.directives.forEach { handleDirective(it) }
}

internal fun <V : NodeVisitor> V.handleInterfaceTypeDefinition(node: InterfaceTypeDefinitionNode) {
    visitInterfaceTypeDefinition(node)
    handleName(node.name)
    node.description?.let(::visitStringValue)
    node.directives.forEach { handleDirective(it) }
    node.interfaces.forEach { handleNamedType(it) }
    node.fields.forEach { handleFieldDefinition(it) }
}

internal fun <V : NodeVisitor> V.handleInputObjectTypeDefinition(node: InputObjectTypeDefinitionNode) {
    visitInputObjectTypeDefinition(node)
    handleName(node.name)
    node.description?.let(::visitStringValue)
    node.directives.forEach { handleDirective(it) }
    node.fields.forEach { handleInputValueDefinition(it) }
}

internal fun <V : NodeVisitor> V.handleScalarTypeDefinition(node: ScalarTypeDefinitionNode) {
    visitScalarTypeDefinition(node)
    handleName(node.name)
    node.description?.let(::visitStringValue)
    node.directives.forEach { handleDirective(it) }
}

internal fun <V : NodeVisitor> V.handleField(node: FieldNode) {
    visitField(node)
    handleName(node.name)
    node.arguments.forEach { handleArgument(it) }
    node.alias?.let { handleName(it) }
    node.directives.forEach { handleDirective(it) }
    node.selectionSet?.let { handleSelectionSet(it) }
}

internal fun <V : NodeVisitor> V.handleSelectionSet(node: SelectionSetNode) {
    visitSelectionSet(node)
    node.selections.forEach { handleSelection(it) }
}

internal fun <V : NodeVisitor> V.handleSelection(node: SelectionNode) =
        when (node) {
            is FieldNode -> handleField(node)
            is FragmentSpreadNode -> handleFragmentSpread(node)
            is InlineFragmentNode -> handleInlineFragment(node)
            else -> Unit
        }

internal fun <V : NodeVisitor> V.handleFragmentSpread(node: FragmentSpreadNode) {
    visitFragmentSpread(node)
    handleName(node.name)
    node.directives.forEach { handleDirective(it) }
}

internal fun <V : NodeVisitor> V.handleInlineFragment(node: InlineFragmentNode) {
    visitInlineFragment(node)
    node.typeCondition?.let(::handleNamedType)
    node.directives.forEach { handleDirective(it) }
    handleSelectionSet(node.selectionSet)
}