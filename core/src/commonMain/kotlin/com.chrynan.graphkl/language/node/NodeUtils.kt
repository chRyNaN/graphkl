package com.chrynan.graphkl.language.node

import com.chrynan.graphkl.language.Kind
import kotlin.reflect.KClass

fun getNodeClassFromKind(kind: Kind): KClass<*> =
        when (kind) {
            Kind.FRAGMENT_SPREAD -> FragmentSpreadNode::class
            Kind.ARGUMENT -> ArgumentNode::class
            Kind.FIELD -> FieldNode::class
            Kind.SELECTION_SET -> SelectionSetNode::class
            Kind.VARIABLE_DEFINITION -> VariableDefinitionNode::class
            Kind.OPERATION_DEFINITION -> OperationDefinitionNode::class
            Kind.DOCUMENT -> DocumentNode::class
            Kind.NAME -> NameNode::class
            Kind.ENUM_TYPE_EXTENSION -> EnumTypeExtensionNode::class
            Kind.INPUT_OBJECT_TYPE_EXTENSION -> InputObjectTypeExtensionNode::class
            Kind.UNION_TYPE_EXTENSION -> UnionTypeExtensionNode::class
            Kind.INTERFACE_TYPE_EXTENSION -> InterfaceTypeExtensionNode::class
            Kind.OBJECT_TYPE_EXTENSION -> ObjectTypeExtensionNode::class
            Kind.SCALAR_TYPE_EXTENSION -> ScalarTypeExtensionNode::class
            Kind.SCHEMA_EXTENSION -> SchemaExtensionNode::class
            Kind.DIRECTIVE_DEFINITION -> DirectiveDefinitionNode::class
            Kind.INPUT_OBJECT_TYPE_DEFINITION -> InputObjectTypeDefinitionNode::class
            Kind.ENUM_VALUE_DEFINITION -> EnumValueDefinitionNode::class
            Kind.ENUM_TYPE_DEFINITION -> EnumTypeDefinitionNode::class
            Kind.UNION_TYPE_DEFINITION -> UnionTypeDefinitionNode::class
            Kind.INTERFACE_TYPE_DEFINITION -> InterfaceTypeDefinitionNode::class
            Kind.INPUT_VALUE_DEFINITION -> InputValueDefinitionNode::class
            Kind.FIELD_DEFINITION -> FieldDefinitionNode::class
            Kind.OBJECT_TYPE_DEFINITION -> ObjectTypeDefinitionNode::class
            Kind.SCALAR_TYPE_DEFINITION -> ScalarTypeDefinitionNode::class
            Kind.OPERATION_TYPE_DEFINITION -> OperationTypeDefinitionNode::class
            Kind.SCHEMA_DEFINITION -> SchemaDefinitionNode::class
            Kind.NON_NULL_TYPE -> NonNullTypeNode::class
            Kind.LIST_TYPE -> ListTypeNode::class
            Kind.NAMED_TYPE -> NamedTypeNode::class
            Kind.DIRECTIVE -> DirectiveNode::class
            Kind.OBJECT_FIELD -> ObjectFieldNode::class
            Kind.OBJECT -> ObjectValueNode::class
            Kind.LIST -> ListValueNode::class
            Kind.ENUM -> EnumValueNode::class
            Kind.NULL -> NullValueNode::class
            Kind.BOOLEAN -> BooleanValueNode::class
            Kind.STRING -> StringValueNode::class
            Kind.FLOAT -> FloatValueNode::class
            Kind.INT -> IntValueNode::class
            Kind.FRAGMENT_DEFINITION -> FragmentDefinitionNode::class
            Kind.INLINE_FRAGMENT -> InlineFragmentNode::class
            Kind.VARIABLE -> VariableNode::class
        }

fun traverse(startWith: Node, operation: (Node) -> Unit) {
    val nodes = mutableListOf(startWith)

    while (nodes.isNotEmpty()) {
        val node = nodes.removeAt(0)

        for (child in node.childNodes) {
            nodes.add(child)
        }

        operation.invoke(node)
    }
}

fun <R : RootNode> R.traverse(operation: (Node) -> Unit) = traverse(startWith = this, operation = operation)