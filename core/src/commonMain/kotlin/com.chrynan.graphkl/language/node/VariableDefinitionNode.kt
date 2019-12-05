package com.chrynan.graphkl.language.node

import com.chrynan.graphkl.language.Kind
import com.chrynan.graphkl.language.Location
import com.chrynan.graphkl.language.Source

/**
 * A [Node] representing a GraphQL variable definition, such as in a Schema, from a [Source]. A variable definition is
 * the declaration of a variable field within a query and including it's possible default value instantiation. For
 * example, the following is a variable definition within a named query:
 *
 * query HeroComparison($first: Int = 3) { ... }
 *
 * The variable starts with the '$' character, followed by a name ('first'), then a type (': Int'), and optionally a
 * default value ('= 3'). This [Node] defines that whole definition sequence. The [variable] property represents the
 * name of the variable (and optionally a value if it was provided in a query to be executed). The [type] property
 * represents the [TypeNode] of the variable (e.g. 'Int'). And the [defaultValue] represents the optional default value
 * assigned to the variable.
 */
data class VariableDefinitionNode(
        override val location: Location? = null,
        val variable: VariableNode,
        val type: TypeNode,
        val defaultValue: ValueNode<Any?>? = null,
        val directives: List<DirectiveNode> = emptyList()
) : BaseNode(kind = Kind.VARIABLE_DEFINITION) {

    override val childNodes: List<Node> = listOfNotNull(variable, type, defaultValue) + directives
}