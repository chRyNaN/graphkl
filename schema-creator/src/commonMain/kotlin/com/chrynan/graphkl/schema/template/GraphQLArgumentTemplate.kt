package com.chrynan.graphkl.schema.template

import com.chrynan.graphkl.language.type.GraphQLArgument

class GraphQLArgumentTemplate(private val getTypeDeclaration: GraphQLTypeDeclarationTemplate) {

    operator fun invoke(argument: GraphQLArgument): String = buildString {
        append("${argument.name}: ${getTypeDeclaration(argument.type)}")

        if (argument.defaultValue != null) {
            append(" = ${argument.defaultValue}")
        }
    }
}