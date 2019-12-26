package com.chrynan.graphkl.kotlin

import com.chrynan.graphkl.kotlin.modifier.PropertyModifier
import com.chrynan.graphkl.kotlin.modifier.VisibilityModifier

data class Property(
        val name: String,
        val type: PropertyType,
        val typeDefinition: TypeDefinition,
        val visibility: VisibilityModifier,
        val modifiers: Set<PropertyModifier>,
        val initializer: String? = null,
        val getter: String? = null,
        val setter: String? = null
) {

    val importStatements: List<ImportStatement> = typeDefinition.importStatements

    override fun toString() = buildString {
        append(visibility.keyword.value)

        if (modifiers.isNotEmpty()) {
            append(" ")
            modifiers.forEach { append(it.keyword.value) }
        }

        append("${type.keyword.value} $name: $typeDefinition")

        if (initializer != null) {
            append(initializer)
        }

        if (getter != null) {
            append("\n\t$getter")
        }

        if (setter != null) {
            append("\n\t$setter")
        }
    }
}