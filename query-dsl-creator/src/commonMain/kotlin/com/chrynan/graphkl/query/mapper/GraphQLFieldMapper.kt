package com.chrynan.graphkl.query.mapper

import com.chrynan.graphkl.kotlin.KotlinDefaultValue
import com.chrynan.graphkl.kotlin.KotlinParameter
import com.chrynan.graphkl.kotlin.KotlinTypeDefinition
import com.chrynan.graphkl.language.type.*
import com.chrynan.graphkl.query.model.QueryFieldDefinition

class GraphQLFieldMapper(
        private val getTypeDefinitionForName: (String) -> KotlinTypeDefinition?,
        private val queryFieldObjectBuilderSuffix: String,
        private val builderParameterName: String,
        private val nestedBuilderParameterName: String,
        private val aliasParameterName: String
) : Mapper<GraphQLField, QueryFieldDefinition?> {

    override fun map(model: GraphQLField): QueryFieldDefinition? {
        // We don't have to create the type explicitly because it will be created during the traversing of the types
        val parameters = model.arguments.map { arg ->
            KotlinParameter(
                    name = arg.name,
                    type = getTypeDefinitionForName(arg.name)
                            ?: KotlinTypeDefinition(packageName = "", className = arg.name),
                    defaultValue = KotlinDefaultValue(hasDefaultValue = arg.defaultValue != null, value = arg.defaultValue))
        }

        return when (val fieldType = model.type) {
            is GraphQLEnumType,
            is GraphQLScalarType -> {
                if (parameters.isEmpty()) {
                    QueryFieldDefinition.Scalar(
                            name = model.name,
                            aliasParameterName = aliasParameterName,
                            parentBuilderPropertyName = builderParameterName)
                } else {
                    QueryFieldDefinition.ScalarWithParameters(
                            name = model.name,
                            aliasParameterName = aliasParameterName,
                            parentBuilderPropertyName = builderParameterName,
                            parameters = parameters
                    )
                }
            }
            is GraphQLObjectType ->
                QueryFieldDefinition.Object(
                        name = model.name,
                        aliasParameterName = aliasParameterName,
                        parentBuilderPropertyName = builderParameterName,
                        parameters = parameters,
                        nestedBuilderClassName = fieldType.name + queryFieldObjectBuilderSuffix,
                        nestedBuilderParameterName = nestedBuilderParameterName)
            is GraphQLInterfaceType ->
                QueryFieldDefinition.Object(
                        name = model.name,
                        aliasParameterName = aliasParameterName,
                        parentBuilderPropertyName = builderParameterName,
                        parameters = parameters,
                        nestedBuilderClassName = fieldType.name + queryFieldObjectBuilderSuffix,
                        nestedBuilderParameterName = nestedBuilderParameterName)
            else -> null
        }
    }
}