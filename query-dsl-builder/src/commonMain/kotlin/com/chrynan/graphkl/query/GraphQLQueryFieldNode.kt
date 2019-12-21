package com.chrynan.graphkl.query

/**
 * A class that represents a field in a GraphQL Query. This could be a Scalar, Enum, Object, or similar field, or could
 * be a Fragment, Inline Fragment, or Named Fragment. This class might contain [nestedFields] depending on the field
 * type. If a field does not contain nested fields, the [nestedFields] property will be empty.
 *
 * @property [nestedFields] The nested fields, if any, that belongs to this field. If this field is a leaf type
 * (Scalar, Enum, etc), then this property will be empty.
 * @property [invocationName] The name used for invoking this field in a GraphQL Query. For instance this may simply be
 * the name of the property, or it could be a Fragment invocation for a Fragment.
 *
 * @author chRyNaN
 */
sealed class GraphQLQueryFieldNode {

    abstract val nestedFields: List<GraphQLQueryFieldNode>

    abstract val invocationName: String

    abstract fun toRequestString(): String

    abstract fun toPrettyString(): String
}

/**
 * An implementation of [GraphQLQueryFieldNode] that directly represents a GraphQL Field. This class does not
 * distinguish between the different field types and can be either one. For instance, this could be a Scalar field,
 * meaning the [nestedFields] property would be empty. Or it could be an Enum field, also meaning the [nestedFields]
 * property would be empty. Or it could be an Object field, which would mean that the [nestedFields] property should
 * not be empty.
 *
 * Example:
 *
 * human(id: "1000") {
 *     name
 *     height
 * }
 *
 * In the above example, the "human", "name", and "height" are all fields. The "name" and "height" are Scalar fields
 * and the "human" field is an Object field that takes in arguments.
 *
 * @property [name] The name of this field.
 * @property [arguments] The [GraphQLQueryArgument]s provided to this field in a Query.
 * @property [directives] The [GraphQLQueryDirective]s specified on this field.
 * @property [alias] An optional alias for this field which will be used in a Query, so the result is returned using
 * the alias and not the name.
 * @property [nestedFields] The nested fields, if any, that belongs to this field. If this field is a leaf type
 * (Scalar, Enum, etc), then this property will be empty.
 *
 * @author chRyNaN
 */
data class GraphQLQueryField(
        val name: String,
        val arguments: List<GraphQLQueryArgument> = emptyList(),
        val directives: List<GraphQLQueryDirective> = emptyList(),
        val alias: String? = null,
        override val nestedFields: List<GraphQLQueryFieldNode> = emptyList()
) : GraphQLQueryFieldNode() {

    override val invocationName: String
        get() = buildString {
            if (alias != null) {
                append("$alias: ")
            }

            append(name)

            if (arguments.isNotEmpty()) {
                append("(")

                arguments.forEachIndexed { index, argument ->
                    append(argument)

                    if (index != arguments.lastIndex) {
                        append(", ")
                    }
                }

                append(")")
            }
        }

    override fun toRequestString() = buildString {
        append(invocationName)

        directives.forEach { append("$it ") }

        append(" { \\n ")

        nestedFields.forEach { append("${it.toRequestString()} \\n ") }

        append("}")
    }

    override fun toPrettyString() = buildString {
        append(invocationName)

        directives.forEach { append("$it ") }

        append(" {\n ")

        nestedFields.forEach { append("${it.toPrettyString()}\n ") }

        append("}")
    }

    override fun toString() = toPrettyString()
}

/**
 * An implementation of [GraphQLQueryFieldNode] that represents a GraphQL Fragment. This represents the definition of a
 * GraphQL Fragment, but it can also be used as a field which would mean that it would be an invocation of a Fragment.
 *
 * Example of a Fragment Definition:
 *
 * fragment comparisonFields on Character {
 *     name
 *     appearsIn
 *     friends {
 *         name
 *     }
 * }
 *
 * Example of a Fragment Field (or invocation of a Fragment):
 *
 * leftComparison: hero(episode: EMPIRE) {
 *     ...comparisonFields
 * }
 *
 * In the above example, the "...comparisonFields" is a Fragment field which is an invocation of the defined
 * "comparisonFields" Fragment on an Object field. This class represents both the definition of the Fragment and the
 * invocation of the defined Fragment. This way it can be used as a field and stored in the [GraphQLQuery] as a
 * definition.
 *
 * @property [name] The name of the Fragment.
 * @property [on] The name of the type this Fragment operates on.
 * @property [directives] The [GraphQLQueryDirective]s specified on this field.
 * @property [nestedFields] The nested fields of this Fragment. These are the fields that are defined in the Fragment
 * definition.
 *
 * @author chRyNaN
 */
data class GraphQLQueryFragment(
        val name: String,
        val on: String,
        val directives: List<GraphQLQueryDirective> = emptyList(),
        override val nestedFields: List<GraphQLQueryFieldNode> = emptyList()
) : GraphQLQueryFieldNode() {

    override val invocationName: String
        get() = "...$name"

    @Suppress("MemberVisibilityCanBePrivate")
    val fragmentDefinitionName: String
        get() = "fragment $name on $on"

    override fun toRequestString() = buildString {
        append(fragmentDefinitionName)

        directives.forEach { append("$it ") }

        append(" { \\n ")

        nestedFields.forEach { append("${it.toRequestString()} \\n ") }

        append("}")
    }

    override fun toPrettyString() = buildString {
        append(fragmentDefinitionName)

        directives.forEach { append("$it ") }

        append(" {\n")

        nestedFields.forEach { append("${it.toPrettyString()}\n") }

        append("}")
    }

    override fun toString() = toPrettyString()
}

/**
 * An implementation of [GraphQLQueryFieldNode] that represents the name of a GraphQL Fragment. This is similar to
 * [GraphQLQueryFragment] but only refers to a previously defined GraphQL Fragment by it's name.
 *
 * @property [name] The name of the Fragment.
 * @property [nestedFields] The nested fields of this Fragment. These are the fields that are defined in the Fragment
 * definition.
 *
 * @author chRyNaN
 */
data class GraphQLQueryNamedFragment(val name: String) : GraphQLQueryFieldNode() {

    override val nestedFields: List<GraphQLQueryFieldNode> = emptyList()

    override val invocationName: String
        get() = "...$name"

    override fun toRequestString() = invocationName

    override fun toPrettyString() = invocationName

    override fun toString() = toPrettyString()
}

/**
 * An implementation of [GraphQLQueryFieldNode] that represents a GraphQL Inline Fragment.
 *
 * Example:
 *
 * ... on Human {
 *     height
 * }
 *
 * In the above example, the "... on Human { ... }" is a GraphQL Inline Fragment. This class represents that whole
 * construct.
 *
 * @property [on] The name of the type this Fragment operates on.
 * @property [directives] The [GraphQLQueryDirective]s specified on this field.
 * @property [nestedFields] The nested fields of this Fragment.
 *
 * @author chRyNaN
 */
data class GraphQLQueryInlineFragment(
        val on: String,
        val directives: List<GraphQLQueryDirective> = emptyList(),
        override val nestedFields: List<GraphQLQueryFieldNode> = emptyList()
) : GraphQLQueryFieldNode() {

    override val invocationName: String
        get() = "... on $on"

    override fun toRequestString() = buildString {
        append(invocationName)

        directives.forEach { append("$it ") }

        append(" { \\n ")

        nestedFields.forEach { append("${it.toRequestString()} \\n ") }

        append("}")
    }

    override fun toPrettyString() = buildString {
        append(invocationName)

        directives.forEach { append("$it ") }

        append(" {\n")

        nestedFields.forEach { append("${it.toPrettyString()}\n") }

        append("}")
    }

    override fun toString() = toPrettyString()
}