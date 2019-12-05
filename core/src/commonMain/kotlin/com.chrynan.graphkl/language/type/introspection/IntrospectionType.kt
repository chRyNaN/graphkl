package com.chrynan.graphkl.language.type.introspection

import com.chrynan.graphkl.language.type.GraphQLType

enum class IntrospectionType(val type: GraphQLType) {

    SCHEMA(type = __Schema),
    DIRECTIVE(type = __Directive),
    DIRECTIVE_LOCATION(type = __DirectiveLocation),
    TYPE(type = __Type),
    FIELD(type = __Field),
    INPUT_VALUE(type = __InputValue),
    ENUM_VALUE(type = __EnumValue),
    TYPE_KIND(type = __TypeKind)
}

val GraphQLType.isIntrospectionType: Boolean
    get() = IntrospectionType.values().firstOrNull { it.type == this } != null