package com.chrynan.graphkl.utils

import com.chrynan.graphkl.language.type.*
import com.chrynan.graphkl.language.type.schema.GraphQLSchema

inline fun <reified T : GraphQLType> GraphQLSchema.reduceType(): List<T> =
        listOfNotNull(queryType, mutationType, subscriptionType)
                .reduceType()

inline fun <reified T : GraphQLType> Iterable<GraphQLType>.reduceType(): List<T> =
        reduceAllTypes()
                .filterIsInstance<T>()
                .toList()

fun Iterable<GraphQLType>.reduceAllTypes(): Sequence<GraphQLType> =
        asSequence()
                .map { getAllTypesFrom(type = it) }
                .fold(emptySequence()) { acc, seq -> acc + seq }

internal fun getAllTypesFrom(type: GraphQLType): List<GraphQLType> {
    val typeList = mutableListOf<GraphQLType>()
    getAllTypesFrom(type = type, typeList = typeList)
    return typeList
}

internal tailrec fun getAllTypesFrom(type: GraphQLType, typeList: MutableList<GraphQLType>) {
    when (type) {
        is GraphQLList -> getAllTypesFrom(type = type.ofType, typeList = typeList)
        is GraphQLNonNull -> getAllTypesFrom(type = type.ofType, typeList = typeList)
        is GraphQLInputObjectType -> getAllTypesFromInputObject(type = type, typeList = typeList)
        is GraphQLInterfaceType -> getAllTypesFromInterface(type = type, typeList = typeList)
        is GraphQLObjectType -> getAllTypesFromObject(type = type, typeList = typeList)
        is GraphQLUnionType -> getAllTypesFromUnion(type = type, typeList = typeList)
        else -> {
            typeList.add(type)
        }
    }
}

internal fun getAllTypesFromInputObject(type: GraphQLInputObjectType, typeList: MutableList<GraphQLType>) {
    typeList.add(type)
    type.fields.filterIsInstance<GraphQLNamedType>()
            .forEach { getAllTypesFrom(type = it, typeList = typeList) }
}

internal fun getAllTypesFromInterface(type: GraphQLInterfaceType, typeList: MutableList<GraphQLType>) {
    typeList.add(type)
    type.fields.filterIsInstance<GraphQLNamedType>()
            .forEach { getAllTypesFrom(type = it, typeList = typeList) }
    type.interfaces.forEach { getAllTypesFromInterface(type = it, typeList = typeList) }
}

internal fun getAllTypesFromObject(type: GraphQLObjectType, typeList: MutableList<GraphQLType>) {
    typeList.add(type)
    type.fields.filterIsInstance<GraphQLNamedType>()
            .forEach { getAllTypesFrom(type = it, typeList = typeList) }
    type.interfaces.forEach { getAllTypesFromInterface(type = it, typeList = typeList) }
}

internal fun getAllTypesFromUnion(type: GraphQLUnionType, typeList: MutableList<GraphQLType>) {
    typeList.add(type)
    type.types.forEach { getAllTypesFromObject(type = it, typeList = typeList) }
}