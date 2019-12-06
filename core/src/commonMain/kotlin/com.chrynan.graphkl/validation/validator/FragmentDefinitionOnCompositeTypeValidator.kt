package com.chrynan.graphkl.validation.validator

import com.chrynan.graphkl.error.GraphQLError
import com.chrynan.graphkl.language.node.FragmentDefinitionNode
import com.chrynan.graphkl.language.type.GraphQLCompositeType
import com.chrynan.graphkl.validation.BaseRule
import com.chrynan.graphkl.validation.ValidationContext
import com.chrynan.graphkl.validation.result.Failure
import com.chrynan.graphkl.validation.result.Success
import com.chrynan.graphkl.validation.result.ValidationResult

/**
 * Executable definitions
 *
 * A GraphQL document is only valid for execution if all definitions are either
 * operation or fragment definitions.
 */
class FragmentDefinitionOnCompositeTypeValidator : NodeValidator<FragmentDefinitionNode> {

    override fun invoke(context: ValidationContext, node: FragmentDefinitionNode): ValidationResult {
        val type = context.schema.typeMap[node.typeCondition.name.value]

        if (type != null && type !is GraphQLCompositeType) {
            return Failure(error = GraphQLError(message = "Fragment cannot condition on non composite types. Node = $node; type = $type"))
        }

        return Success(rule = BaseRule.FRAGMENTS_ON_COMPOSITE_TYPES)
    }
}