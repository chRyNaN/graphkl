package com.chrynan.graphkl.language.node

import com.chrynan.graphkl.language.Source

/**
 * A [Node] interface that represents a definition of something in a GraphQL Schema or Query from a [Source]. For
 * instance, an object type must be defined in a Schema so that it can be queried. That definition is considered a
 * [DefinitionNode]. Note that a definition is not the actual values provided in a query. Extensions of this interface
 * represent specific definition categories as declared below:
 *
 * Definition :
 *   - ExecutableDefinition
 *   - TypeSystemDefinition
 *   - TypeSystemExtension
 *
 * ExecutableDefinition :
 *   - OperationDefinition
 *   - FragmentDefinition
 */
interface DefinitionNode : Node