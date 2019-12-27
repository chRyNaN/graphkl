package com.chrynan.graphkl.query.creator

import com.chrynan.graphkl.kotlin.KotlinOutput
import com.chrynan.graphkl.kotlin.KotlinParameter
import com.chrynan.graphkl.kotlin.KotlinTypeDefinition
import com.chrynan.graphkl.language.type.*
import com.chrynan.graphkl.language.type.scalar.*
import com.chrynan.graphkl.language.type.schema.GraphQLSchema
import com.chrynan.graphkl.query.mapper.GraphQLFieldMapper
import com.chrynan.graphkl.query.model.QueryFieldObjectBuilderClass
import com.chrynan.graphkl.query.model.QueryInputObject
import com.chrynan.graphkl.query.model.QueryType
import com.chrynan.graphkl.query.template.*

class QueryBuilderCreator(
        externalTypes: List<KotlinTypeDefinition> = emptyList(),
        private val entryFunctionTemplate: QueryEntryFunctionTemplate = QueryEntryFunctionTemplate(),
        private val rootObjectTemplate: QueryRootObjectBuilderClassTemplate = QueryRootObjectBuilderClassTemplate(),
        private val objectTemplate: QueryFieldObjectBuilderClassTemplate = QueryFieldObjectBuilderClassTemplate(),
        private val scalarTemplate: GraphQLScalarTypeTemplate = GraphQLScalarTypeTemplate(),
        private val enumTemplate: GraphQLEnumTypeTemplate = GraphQLEnumTypeTemplate(),
        private val inputObjectTemplate: QueryInputObjectTemplate = QueryInputObjectTemplate()
) {

    companion object {

        private const val QUERY_FIELD_OBJECT_BUILDER_SUFFIX = "QueryFieldObjectBuilder"
        private const val QUERY_ROOT_OBJECT_BUILDER_SUFFIX = "QueryRootObjectBuilder"
        private const val QUERY_BUILDER_SUFFIX = "QueryBuilder"
        private const val BUILDER_PARAMETER_NAME = "queryBuilder"
        private const val NESTED_BUILDER_PARAMETER_NAME = "nestedQueryBuilder"
        private const val ALIAS_PARAMETER_NAME = "alias"

        private val QUERY_FIELD_OBJECT_BUILDER_TYPE_DEFINITION = KotlinTypeDefinition(
                packageName = "com.chrynan.graphkl.query.builder",
                className = "GraphQLQueryFieldObjectBuilder")
    }

    private val externalTypeMap = externalTypes.associateBy { it.className }
    private val createdTypeMap = mutableMapOf<String, QueryType>()
    private val queryBuilderMap = mutableMapOf<String, QueryType>()

    private val defaultScalarTypeMap = mapOf(
            GraphQLInt.name to KotlinTypeDefinition(packageName = "kotlin", className = "Int"),
            GraphQLString.name to KotlinTypeDefinition(packageName = "kotlin", className = "String"),
            GraphQLBoolean.name to KotlinTypeDefinition(packageName = "kotlin", className = "Boolean"),
            GraphQLFloat.name to KotlinTypeDefinition(packageName = "kotlin", className = "Float"),
            GraphQLID.name to KotlinTypeDefinition(packageName = "kotlin", className = "String")
    )

    private val graphQLFieldMapper = GraphQLFieldMapper(
            getTypeDefinitionForName = { getTypeDefinitionForName(it) },
            queryFieldObjectBuilderSuffix = QUERY_FIELD_OBJECT_BUILDER_SUFFIX,
            builderParameterName = BUILDER_PARAMETER_NAME,
            nestedBuilderParameterName = NESTED_BUILDER_PARAMETER_NAME,
            aliasParameterName = ALIAS_PARAMETER_NAME)

    private val typeBuilder = StringBuilder()
    private val queryBuilder = StringBuilder()

    operator fun invoke(schema: GraphQLSchema): KotlinOutput {
        // Create the Root Query Builders
        // TODO

        // Create the Input Types and Output Query Builders
        schema.types.forEach {
            when (it) {
                is GraphQLEnumType,
                is GraphQLInputObjectType,
                is GraphQLScalarType -> handleInputType(it)
                is GraphQLObjectType,
                is GraphQLInterfaceType -> handleOutputType(it)
            }
        }

        return KotlinOutput(files = emptyList())
    }

    private fun handleOutputType(type: GraphQLNamedType) {
        if (queryBuilderMap[type.name] == null) {
            val builderClass = when (type) {
                is GraphQLObjectType -> getQueryFieldObjectBuilderClassForType(type)
                is GraphQLInterfaceType -> getQueryFieldObjectBuilderClassForType(type)
                else -> null
            }

            if (builderClass != null) {
                val newTypeDefinition = KotlinTypeDefinition(packageName = "", className = builderClass.name)
                queryBuilderMap[builderClass.name] = QueryType(kotlinType = newTypeDefinition, graphQLType = type)

                queryBuilder.append("${objectTemplate(builderClass)}\n\n")
            }
        }
    }

    private fun handleInputType(type: GraphQLNamedType) {
        if (!hasTypeDefinitionForGraphQLType(type)) {
            val typeString = when (type) {
                is GraphQLScalarType -> scalarTemplate(type)
                is GraphQLEnumType -> enumTemplate(type)
                is GraphQLInputObjectType -> {
                    inputObjectTemplate(QueryInputObject("", emptyList())) // TODO
                }
                else -> null
            }

            if (typeString != null) {
                val newTypeDefinition = KotlinTypeDefinition(packageName = "", className = type.name)
                createdTypeMap[type.name] = QueryType(kotlinType = newTypeDefinition, graphQLType = type)

                typeBuilder.append("$typeString\n\n")
            }
        }
    }

    private fun hasTypeDefinitionForGraphQLType(type: GraphQLNamedType): Boolean {
        val typeDefinition = defaultScalarTypeMap[type.name] ?: externalTypeMap[type.name]
        ?: createdTypeMap[type.name]?.kotlinType

        return typeDefinition != null
    }

    private fun getTypeDefinitionForName(name: String): KotlinTypeDefinition? =
            defaultScalarTypeMap[name] ?: externalTypeMap[name]
            ?: createdTypeMap[name]?.kotlinType

    private fun getQueryFieldObjectBuilderClassForType(type: GraphQLObjectType): QueryFieldObjectBuilderClass {
        val queryBuilderClassName = type.name + QUERY_FIELD_OBJECT_BUILDER_SUFFIX
        val builderParameter = KotlinParameter(name = BUILDER_PARAMETER_NAME, type = QUERY_FIELD_OBJECT_BUILDER_TYPE_DEFINITION)

        val fields = type.fields.mapNotNull {
            // We don't have to create the type explicitly because it will be created during the traversing of the types
            graphQLFieldMapper.map(it)
        }.toSet()

        return QueryFieldObjectBuilderClass(
                name = queryBuilderClassName,
                builderParameter = builderParameter,
                fields = fields)
    }

    private fun getQueryFieldObjectBuilderClassForType(type: GraphQLInterfaceType): QueryFieldObjectBuilderClass {
        val queryBuilderClassName = type.name + QUERY_FIELD_OBJECT_BUILDER_SUFFIX
        val builderParameter = KotlinParameter(name = BUILDER_PARAMETER_NAME, type = QUERY_FIELD_OBJECT_BUILDER_TYPE_DEFINITION)

        val fields = type.fields.mapNotNull {
            // We don't have to create the type explicitly because it will be created during the traversing of the types
            graphQLFieldMapper.map(it)
        }.toSet()

        return QueryFieldObjectBuilderClass(
                name = queryBuilderClassName,
                builderParameter = builderParameter,
                fields = fields)
    }
}