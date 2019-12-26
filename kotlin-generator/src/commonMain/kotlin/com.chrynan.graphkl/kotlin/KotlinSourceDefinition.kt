package com.chrynan.graphkl.kotlin

import com.chrynan.graphkl.kotlin.modifier.ClassModifier
import com.chrynan.graphkl.kotlin.modifier.VisibilityModifier

sealed class KotlinSourceDefinition {

    abstract val name: String
    abstract val extendsFrom: List<KotlinSourceDefinition>
    abstract val importStatements: List<KotlinImportStatement>

    class Class(
            override val name: String,
            val visibility: VisibilityModifier,
            val modifiers: List<ClassModifier> = emptyList(),
            val superClass: Class? = null,
            val superInterfaces: List<Interface> = emptyList(),
            val constructors: List<KotlinConstructor>,
            val properties: List<KotlinProperty> = emptyList(),
            val functions: List<KotlinFunction> = emptyList(),
            val init: ((Class) -> String)? = null
    ) : KotlinSourceDefinition() {

        override val extendsFrom: List<KotlinSourceDefinition> = listOfNotNull(superClass) + superInterfaces

        override val importStatements: List<KotlinImportStatement> = constructors.flatMap { it.importStatements } +
                functions.flatMap { it.importStatements } +
                properties.flatMap{it.importStatements} +
                superInterfaces.flatMap{it.importStatements}
    }

    class Interface(
            override val name: String,
            val superInterfaces: List<Interface> = emptyList(),
            val properties: List<KotlinProperty> = emptyList(),
            val functions: List<KotlinFunction> = emptyList()
    ) : KotlinSourceDefinition() {

        override val extendsFrom: List<KotlinSourceDefinition> = superInterfaces

        override val importStatements: List<KotlinImportStatement> = emptyList()
    }

    class Object(
            override val name: String,
            val properties: List<KotlinProperty> = emptyList(),
            val functions: List<KotlinFunction> = emptyList()
    ) : KotlinSourceDefinition() {

        override val extendsFrom: List<KotlinSourceDefinition> = emptyList()

        override val importStatements: List<KotlinImportStatement> = emptyList()
    }
}