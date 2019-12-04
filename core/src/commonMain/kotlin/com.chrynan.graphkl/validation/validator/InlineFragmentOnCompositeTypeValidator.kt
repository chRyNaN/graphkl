package com.chrynan.graphkl.validation.validator

import com.chrynan.graphkl.language.node.InlineFragmentNode
import com.chrynan.graphkl.validation.ValidationContext
import com.chrynan.graphkl.validation.result.ValidationResult

class InlineFragmentOnCompositeTypeValidator : NodeValidator<InlineFragmentNode> {

    override fun invoke(context: ValidationContext, node: InlineFragmentNode): ValidationResult {
        val typeCondition = node.typeCondition

        if (typeCondition != null) {

        }

        TODO()
    }
}