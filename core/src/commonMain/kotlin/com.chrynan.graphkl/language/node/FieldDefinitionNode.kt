package com.chrynan.graphkl.language.node

import com.chrynan.graphkl.language.Kind
import com.chrynan.graphkl.language.Location
import com.chrynan.graphkl.language.Source

/**
 * A [Node] representing a GraphQL field definition, such as in a Schema, from a [Source]. A field definition is a
 * declaration of a field on an Object. For example, the following is a field on an object in a query:
 *
 * hero {
 *     name
 * }
 *
 * In the above query, the 'name' is a field belonging to the 'hero' object. In a Schema, a field is defined with a
 * field definition. For example, the following are field definitions on a type within a Schema:
 *
 * type Character {
 *     name: String!
 *     appearsIn: [Episode!]!
 * }
 *
 * In the above Schema, the 'name' and 'appearsIn' are field definitions within the type 'Character'. A field definition
 * begins with the name of the field ('name'), followed by optional arguments (e.g. '(length: Length)'), then a colon
 * (':'), and finally the type of the field ('String!'). The exclamation point means that the type is non-nullable, the
 * absence of an exclamation point means that the type is nullable. This [Node] defines that whole definition sequence.
 * The [name] property represents the name of the field. The [type] property represents the type of the field. And the
 * [arguments] property represents the list of arguments on the field (if the list is empty, then there are no
 * arguments).
 *
 * Note that this [Node] represents the definition of a field in a Schema, for the field used in a query, such as in the
 * first example above, refer to the [FieldNode].
 */
data class FieldDefinitionNode(
        override val location: Location? = null,
        val description: StringValueNode? = null,
        val name: NameNode,
        val arguments: List<InputValueDefinitionNode> = emptyList(),
        val type: TypeNode,
        val directives: List<DirectiveNode> = emptyList()
) : BaseNode(kind = Kind.FIELD_DEFINITION)