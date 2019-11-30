package com.chrynan.graphkl.schema.template

import com.chrynan.graphkl.language.type.GraphQLField

class GraphQLFieldTemplate(
        private val getTypeDeclaration: GraphQLTypeDeclarationTemplate,
        private val getArgument: GraphQLArgumentTemplate
) {

    operator fun invoke(field: GraphQLField): String = buildString {
        append(field.name)

        if (field.arguments.isNotEmpty()) {
            append("(")

            field.arguments.forEachIndexed { index, argument ->
                append(getArgument(argument))

                if (index != field.arguments.size - 1) {
                    append(", ")
                }
            }

            append(")")
        }

        append(": ${getTypeDeclaration(field.type)}")
    }
}