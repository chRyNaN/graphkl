package com.chrynan.graphkl.query.template

import com.chrynan.graphkl.language.type.GraphQLEnumValue

class GraphQLEnumValueTemplate : Template<GraphQLEnumValue> {

    override fun invoke(model: GraphQLEnumValue) = model.name
}