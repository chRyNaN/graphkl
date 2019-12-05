package com.chrynan.graphkl.language.node

import com.chrynan.graphkl.language.Kind
import com.chrynan.graphkl.language.Location
import com.chrynan.graphkl.language.Source

/**
 * A [Node] representing a GraphQL field within a query from a [Source]. For example, the following is a field on an
 * object in a query:
 *
 * hero {
 *     name
 * }
 *
 * In the above query, the 'name' is a field belonging to the 'hero' object. A field may contain arguments. For example,
 * consider the following GraphQL query:
 *
 * human(id: "1000") {
 *     name
 *     height
 * }
 *
 * In the above query, 'human', is a field within a containing object and it has an argument of 'id' with a value of
 * '1000'. Also, 'name' and 'height' are fields, with no arguments, returned from the human object. A GraphQL field in
 * a query, contains the name ('human') and an optional list of arguments with the corresponding values
 * ('(id: "1000")'). Also, there could be an alias which lets you rename the result of the field query to something
 * else. The would look like the following:
 *
 * empireHero: hero(episode: EMPIRE) {
 *     name
 * }
 *
 * In the above query, the 'empireHero' is the alias name of the returned field. An alias is followed by a colon (':'),
 * and then the normal field declaration. This [Node] defines that entire sequence. The [alias] property represents the
 * field response alias. The [name] property represents the name of the field. And the [arguments] property represents
 * the arguments and their values of the field.
 *
 * Note that for the definitions of the fields for a Schema, refer to the [FieldDefinitionNode].
 */
data class FieldNode(
        override val location: Location? = null,
        val alias: NameNode? = null,
        val name: NameNode,
        val arguments: List<ArgumentNode> = emptyList(),
        val directives: List<DirectiveNode> = emptyList(),
        val selectionSet: SelectionSetNode? = null
) : BaseNode(kind = Kind.FIELD),
        SelectionNode {

    override val childNodes: List<Node> = listOfNotNull(alias, name, selectionSet) + arguments + directives
}