@file:Suppress("unused")

package com.chrynan.graphkl.annotation

@MustBeDocumented
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS)
annotation class GraphQLMutation(val name: String = "")
