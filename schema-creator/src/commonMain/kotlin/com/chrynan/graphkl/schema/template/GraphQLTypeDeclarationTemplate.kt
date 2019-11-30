package com.chrynan.graphkl.schema.template

import com.chrynan.graphkl.language.type.GraphQLList
import com.chrynan.graphkl.language.type.GraphQLNamedType
import com.chrynan.graphkl.language.type.GraphQLNonNull
import com.chrynan.graphkl.language.type.GraphQLType

/**
 * A template for the type declaration, such as, on an object field. For example:
 *
 * type Character {
 *     name: String!
 *     appearsIn: [Episode!]!
 * }
 *
 * In the above GraphQL type definition there are two fields: 'name' and 'appearsIn'. This template defines the types
 * that are specified on each of those fields: 'String!' and '\[Episode\]!'
 */
class GraphQLTypeDeclarationTemplate {

    operator fun invoke(type: GraphQLType): String =
            when (type) {
                is GraphQLList -> getListType(type)
                is GraphQLNonNull -> getNonNullType(type)
                is GraphQLNamedType -> getNamedType(type)
                else -> ""
            }

    private fun getListType(type: GraphQLList): String = "[${invoke(type = type.ofType)}]"

    private fun getNonNullType(type: GraphQLNonNull): String = "${invoke(type = type.ofType)}!"

    private fun getNamedType(type: GraphQLNamedType): String = type.name
}