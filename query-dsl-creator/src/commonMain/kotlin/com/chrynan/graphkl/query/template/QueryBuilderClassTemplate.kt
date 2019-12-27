package com.chrynan.graphkl.query.template

import com.chrynan.graphkl.query.model.QueryBuilderClass

class QueryBuilderClassTemplate : Template<QueryBuilderClass> {

    override fun invoke(model: QueryBuilderClass): String = """
        class ${model.name}(private val ${model.builderParameter}) {
        
            fun query(${model.operationNameParameterName}: String? = null, ${model.queryParameter.name}: ${model.queryParameter.type}.() -> Unit) {
                ${model.builderParameter}.query(operationName = ${model.operationNameParameterName}) {
                    ${model.queryParameter.name}.invoke(${model.queryParameter.type}(this))
                }
            }
        
            fun mutation(${model.operationNameParameterName}: String? = null, ${model.mutationParameter.name}: ${model.mutationParameter.type}.() -> Unit) {
                ${model.builderParameter}.mutation(operationName = ${model.operationNameParameterName}) {
                    ${model.mutationParameter.name}.invoke(${model.mutationParameter.type}(this))
                }
            }   
        
            fun subscription(${model.operationNameParameterName}: String? = null, ${model.subscriptionParameter.name}: ${model.subscriptionParameter.type}.() -> Unit) {
                ${model.builderParameter}.subscription(operationName = ${model.operationNameParameterName}) {
                    ${model.subscriptionParameter.name}.invoke(${model.subscriptionParameter.type}(this))
                }
            }
        }
    """.trimIndent()
}