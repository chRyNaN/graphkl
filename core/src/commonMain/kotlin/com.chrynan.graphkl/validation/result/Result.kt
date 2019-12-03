package com.chrynan.graphkl.validation.result

import com.chrynan.graphkl.language.error.GraphQLError
import com.chrynan.graphkl.validation.ValidationRule

sealed class ValidationResult

data class Success(val rule: ValidationRule) : ValidationResult()

data class Failure(val errors: List<GraphQLError>) : ValidationResult()