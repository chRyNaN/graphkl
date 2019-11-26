package com.chrynan.graphkl.dsl.schema

import com.chrynan.graphkl.language.type.GraphQLList
import com.chrynan.graphkl.language.type.GraphQLNonNull
import com.chrynan.graphkl.language.type.GraphQLNullableType
import com.chrynan.graphkl.language.type.GraphQLType

fun GraphQLNullableType.asNonNull() = GraphQLNonNull(ofType = this)

fun GraphQLType.asList() = GraphQLList(ofType = this)