package com.chrynan.graphkl.language.visitor

import com.chrynan.graphkl.language.node.*

interface ValueNodeVisitor {

    fun visitVariable(node: VariableNode) {}

    fun visitStringValue(node: StringValueNode) {}

    fun visitObjectValue(node: ObjectValueNode) {}

    fun visitNullValue(node: NullValueNode) {}

    fun visitListValue(node: ListValueNode) {}

    fun visitIntValue(node: IntValueNode) {}

    fun visitFloatValue(node: FloatValueNode) {}

    fun visitEnumValue(node: EnumValueNode) {}

    fun visitBooleanValue(node: BooleanValueNode) {}
}