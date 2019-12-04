package com.chrynan.graphkl.validation.validator

import com.chrynan.graphkl.language.node.Node
import com.chrynan.graphkl.validation.ValidationContext
import com.chrynan.graphkl.validation.result.ValidationResult

interface NodeValidator<N : Node> {

    operator fun invoke(context: ValidationContext, node: N): ValidationResult
}