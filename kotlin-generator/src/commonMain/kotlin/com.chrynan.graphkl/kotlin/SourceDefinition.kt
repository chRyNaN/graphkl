package com.chrynan.graphkl.kotlin

import com.chrynan.graphkl.kotlin.modifier.ClassModifier
import com.chrynan.graphkl.kotlin.modifier.VisibilityModifier

sealed class SourceDefinition {

    abstract val name: String
    abstract val extendsFrom: List<SourceDefinition>
    abstract val importStatements: List<ImportStatement>

    class Class(
            override val name: String,
            val visibility: VisibilityModifier,
            val modifiers: List<ClassModifier> = emptyList(),
            val superClass: Class? = null,
            val superInterfaces: List<Interface> = emptyList(),
            val constructors: List<Constructor>,
            val properties: List<Property> = emptyList(),
            val functions: List<Function> = emptyList(),
            val init: ((Class) -> String)? = null
    ) : SourceDefinition() {

        override val extendsFrom: List<SourceDefinition> = listOfNotNull(superClass) + superInterfaces

        override val importStatements: List<ImportStatement> = constructors.flatMap { it.importStatements } +
                functions.flatMap { it.importStatements } +
                properties.flatMap{it.importStatements} +
                superInterfaces.flatMap{it.importStatements}
    }

    class Interface(
            override val name: String,
            val superInterfaces: List<Interface> = emptyList(),
            val properties: List<Property> = emptyList(),
            val functions: List<Function> = emptyList()
    ) : SourceDefinition() {

        override val extendsFrom: List<SourceDefinition> = superInterfaces

        override val importStatements: List<ImportStatement> = emptyList()
    }

    class Object(
            override val name: String,
            val properties: List<Property> = emptyList(),
            val functions: List<Function> = emptyList()
    ) : SourceDefinition() {

        override val extendsFrom: List<SourceDefinition> = emptyList()

        override val importStatements: List<ImportStatement> = emptyList()
    }
}