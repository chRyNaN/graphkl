package com.chrynan.graphkl.validation.validator

import com.chrynan.graphkl.language.error.GraphQLError
import com.chrynan.graphkl.language.node.DocumentNode
import com.chrynan.graphkl.language.node.ExecutableDefinitionNode
import com.chrynan.graphkl.validation.BaseRule
import com.chrynan.graphkl.validation.result.Failure
import com.chrynan.graphkl.validation.result.Success
import com.chrynan.graphkl.validation.result.ValidationResult

/**
 * Executable definitions
 *
 * A GraphQL document is only valid for execution if all definitions are either
 * operation or fragment definitions.
 */
class ExecutableDefinitionsValidator : NodeValidator<DocumentNode> {

    override fun invoke(node: DocumentNode): ValidationResult {
        val errors = node.definitions.filter { it !is ExecutableDefinitionNode }
                .map { GraphQLError(message = "The definition $it must be executable for a valid executable GraphQL Document.") }

        return if (errors.isEmpty()) Success(rule = BaseRule.EXECUTABLE_DEFINITIONS) else Failure(errors = errors)
    }
}