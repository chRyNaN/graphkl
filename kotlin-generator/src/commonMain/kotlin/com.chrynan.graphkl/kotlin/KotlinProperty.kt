package com.chrynan.graphkl.kotlin

import com.chrynan.graphkl.kotlin.modifier.PropertyModifier
import com.chrynan.graphkl.kotlin.modifier.PropertyType
import com.chrynan.graphkl.kotlin.modifier.VisibilityModifier

data class KotlinProperty(
        val name: String,
        val type: PropertyType = PropertyType.VAL,
        val typeDefinition: KotlinTypeDefinition,
        val visibility: VisibilityModifier = VisibilityModifier.PUBLIC,
        val modifiers: Set<PropertyModifier> = emptySet(),
        val initializer: String? = null,
        val getter: String? = null,
        val setter: String? = null
) {

    val importStatements: List<KotlinImportStatement> = typeDefinition.importStatements

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