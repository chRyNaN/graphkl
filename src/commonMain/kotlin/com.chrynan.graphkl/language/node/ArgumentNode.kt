package com.chrynan.graphkl.language.node

import com.chrynan.graphkl.language.Kind
import com.chrynan.graphkl.language.Location
import com.chrynan.graphkl.language.Source

/**
 * A [Node] representing a GraphQL argument on a field within a query, from a [Source]. For example, consider the
 * following GraphQL query:
 *
 * human(id: "1000") {
 *     name
 *     height(unit: FOOT)
 * }
 *
 * In the above query, the field 'human' has an argument of 'id' with value '1000'. Also, there is a field 'height' that
 * has an argument 'unit' with a value of 'FOOT'. An argument is provided in parentheses directly after the name of a
 * field and multiple arguments are separated by commas (','). An argument begins with it's name ('unit'), followed by a
 * colon (':'), and then it's value ('FOOT'). This [Node] represents the whole sequence for a single argument. The
 * [name] property represents the name of the argument and the [value] property represents the value of the argument.
 *
 * Note that argument definitions on Schemas are represented by the [InputValueDefinitionNode].
 */
data class ArgumentNode(
        override val location: Location? = null,
        val name: NameNode,
        val value: ValueNode<Any?>
) : BaseNode(kind = Kind.ARGUMENT)