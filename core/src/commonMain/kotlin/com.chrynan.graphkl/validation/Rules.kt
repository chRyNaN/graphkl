package com.chrynan.graphkl.validation

enum class Rules {

    EXECUTABLE_DEFINITIONS,
    UNIQUE_OPERATION_NAMES,
    LONE_ANONYMOUS_OPERATION,
    SINGLE_FIELD_SUBSCRIPTIONS,
    KNOWN_TYPE_NAMES,
    FRAGMENTS_ON_COMPOSITE_TYPES,
    VARIABLES_ARE_INPUT_TYPES,
    SCALAR_LEAFS,
    FIELDS_ON_CORRECT_TYPE,
    UNIQUE_FRAGMENT_NAMES,
    KNOWN_FRAGMENT_NAMES,
    NOUN_USED_FRAGMENTS,
    POSSIBLE_FRAGMENT_SPREADS,
    NO_FRAGMENT_CYCLES,
    UNIQUE_VARIABLE_NAMES,
    NOUN_DEFINED_VARIABLES,
    NOUN_USED_VARIABLES,
    KNOWN_DIRECTIVES,
    UNIQUE_DIRECTIVES_PER_LOCATION,
    KNOWN_ARGUMENT_NAMES,
    UNIQUE_ARGUMENT_NAMES,
    VALUES_OF_CORRECT_TYPE,
    PROVIDED_REQUIRED_ARGUMENTS,
    VARIABLES_IN_ALLOWED_POSITION,
    OVERLAPPING_FIELDS_CAN_BE_MERGED,
    UNIQUE_INPUT_FIELD_NAMES
}