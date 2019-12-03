package com.chrynan.graphkl.validation.validator

import com.chrynan.graphkl.language.node.Node
import com.chrynan.graphkl.validation.result.ValidationResult

interface NodeValidator<N : Node> {

    operator fun invoke(node: N): ValidationResult
}