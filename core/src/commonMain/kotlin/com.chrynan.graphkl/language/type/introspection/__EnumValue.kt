package com.chrynan.graphkl.language.type.introspection

import com.chrynan.graphkl.language.type.GraphQLField
import com.chrynan.graphkl.language.type.GraphQLNonNull
import com.chrynan.graphkl.language.type.GraphQLObjectType
import com.chrynan.graphkl.language.type.scalar.GraphQLBoolean
import com.chrynan.graphkl.language.type.scalar.GraphQLString

@Suppress("ObjectPropertyName")
val __EnumValue = GraphQLObjectType(
        name = "__EnumValue",
        description = """
            One possible value for a given Enum. Enum values are unique values, not a placeholder for a string or 
            numeric value. However an Enum value is returned in a JSON response as a string.
        """.trimIndent(),
        fields = listOf(
                GraphQLField(
                        name = "name",
                        type = GraphQLNonNull(GraphQLString)),
                GraphQLField(
                        name = "description",
                        type = GraphQLString),
                GraphQLField(
                        name = "isDeprecated",
                        type = GraphQLNonNull(GraphQLBoolean)),
                GraphQLField(
                        name = "deprecationReason",
                        type = GraphQLString))
)