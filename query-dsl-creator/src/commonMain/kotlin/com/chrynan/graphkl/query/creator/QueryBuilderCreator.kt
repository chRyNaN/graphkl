package com.chrynan.graphkl.query.creator

import com.chrynan.graphkl.kotlin.*
import com.chrynan.graphkl.language.type.*
import com.chrynan.graphkl.language.type.scalar.*
import com.chrynan.graphkl.language.type.schema.GraphQLSchema
import com.chrynan.graphkl.query.model.QueryFieldObjectBuilderClass
import com.chrynan.graphkl.query.template.QueryEntryFunctionTemplate
import com.chrynan.graphkl.query.template.QueryFieldObjectBuilderClassTemplate
import com.chrynan.graphkl.query.template.QueryRootObjectBuilderClassTemplate

class QueryBuilderCreator(
        externalTypes: List<KotlinTypeDefinition> = emptyList(),
        private val entryFunctionTemplate: QueryEntryFunctionTemplate = QueryEntryFunctionTemplate(),
        private val rootObjectTemplate: QueryRootObjectBuilderClassTemplate = QueryRootObjectBuilderClassTemplate(),
        private val objectTemplate: QueryFieldObjectBuilderClassTemplate = QueryFieldObjectBuilderClassTemplate()
) {

    private val externalTypeMap = externalTypes.associateBy { it.className }
    private val createdTypeMap = mutableMapOf<String, KotlinTypeDefinition>()
    private val queryBuilderMap = mutableMapOf<String, QueryFieldObjectBuilderClass>()

    private val defaultScalarTypeMap = mapOf(
            GraphQLInt.name to KotlinTypeDefinition(packageName = "kotlin", className = "Int"),
            GraphQLString.name to KotlinTypeDefinition(packageName = "kotlin", className = "String"),
            GraphQLBoolean.name to KotlinTypeDefinition(packageName = "kotlin", className = "Boolean"),
            GraphQLFloat.name to KotlinTypeDefinition(packageName = "kotlin", className = "Float"),
            GraphQLID.name to KotlinTypeDefinition(packageName = "kotlin", className = "String")
    )

    private val defaultCustomScalarTypeDefinition = KotlinTypeDefinition(packageName = "kotlin", className = "String")

    private val files = mutableListOf<KotlinFile>()

    operator fun invoke(schema: GraphQLSchema): KotlinOutput {
        schema.types.forEach {
            when (it) {
                is GraphQLEnumType -> handleEnumType(it)
                is GraphQLInputObjectType -> handleInputObjectType(it)
                is GraphQLObjectType -> handleOutputObjectType(it)
                is GraphQLScalarType -> handleScalarType(it)
                is GraphQLInterfaceType -> handleInterfaceType(it)
                is GraphQLUnionType -> handleUnionType(it)
            }
        }

        return KotlinOutput(files = files)
    }

    private fun handleEnumType(type: GraphQLEnumType) {

    }

    private fun handleInputObjectType(type: GraphQLInputObjectType) {

    }

    private fun handleOutputObjectType(type: GraphQLObjectType) {
        if (externalTypeMap[type.name] ?: createdTypeMap[type.name] == null) {
            val builderClassName = "${type.name}QueryBuilder"
            val type = KotlinTypeDefinition(
                    packageName = "com.chrynan.graphkl.query.builder",
                    className = "GraphQLQueryFieldObjectBuilder")

            KotlinConstructor(isPrimary = true, parameters = listOf())
        }
    }

    private fun handleScalarType(type: GraphQLScalarType) {
        val typeDefinition = defaultScalarTypeMap[type.name] ?: externalTypeMap[type.name] ?: createdTypeMap[type.name]

        if (typeDefinition == null) {
            createdTypeMap[type.name] = defaultCustomScalarTypeDefinition
            files += KotlinFile(
                    name = type.name,
                    packageName = "",
                    typeAliases = listOf(
                            KotlinTypeAlias(name = type.name, type = defaultCustomScalarTypeDefinition)))
        }
    }

    private fun handleInterfaceType(type: GraphQLInterfaceType) {

    }

    private fun handleUnionType(type: GraphQLUnionType) {

    }
}