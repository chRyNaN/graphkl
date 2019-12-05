package com.chrynan.graphkl.validation.validator

import com.chrynan.graphkl.error.GraphQLError
import com.chrynan.graphkl.language.node.InlineFragmentNode
import com.chrynan.graphkl.language.type.GraphQLCompositeType
import com.chrynan.graphkl.validation.BaseRule
import com.chrynan.graphkl.validation.ValidationContext
import com.chrynan.graphkl.validation.result.Failure
import com.chrynan.graphkl.validation.result.Success
import com.chrynan.graphkl.validation.result.ValidationResult

/**
 * Fragments on composite type
 *
 * Fragments use a type condition to determine if they apply, since fragments
 * can only be spread into a composite type (object, interface, or union), the
 * type condition must also be a composite type.
 */
class InlineFragmentOnCompositeTypeValidator : NodeValidator<InlineFragmentNode> {

    override fun invoke(context: ValidationContext, node: InlineFragmentNode): ValidationResult {
        val typeCondition = node.typeCondition

        if (typeCondition != null) {
            val type = context.schema.namedTypeMap[typeCondition.name.value]

            if (type != null && type !is GraphQLCompositeType) {
                return Failure(error = GraphQLError(message = "Fragment cannot condition on non composite types. Node = $node; type = $type"))
            }
        }

        return Success(rule = BaseRule.FRAGMENTS_ON_COMPOSITE_TYPES)
    }
}