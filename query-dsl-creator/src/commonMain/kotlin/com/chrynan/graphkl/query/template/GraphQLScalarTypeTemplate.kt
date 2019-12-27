package com.chrynan.graphkl.query.template

import com.chrynan.graphkl.language.type.GraphQLScalarType

class GraphQLScalarTypeTemplate : Template<GraphQLScalarType> {

    override fun invoke(model: GraphQLScalarType) = "typealias ${model.name} = String"
}