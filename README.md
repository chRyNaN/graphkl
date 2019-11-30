## graphkl

A [Kotlin](https://kotlinlang.org/) library for working with [GraphQL](https://graphql.org/).

This project consists of multiple independent modules, each available as their own library, providing different utilities for working with GraphQL. Refer to each module's **README** file for module specific information.

### Modules

#### core
* Specification implementation
* Lexer/Parser
* Models
* Base module

#### query-dsl-annotation
* Annotations for an annotation processor that generates a Kotlin query DSL based on a GraphQL Schema

#### query-dsl-creator
* Responsible for creating the Kotlin query DSL
* Depends on the **core** and **query-dsl-builder** modules
* Can be called from an annotation processor, build system plugin, or compiler plugin to generate a Kotlin query DSL

#### query-dsl-builder
* Contains utilities for helping in the creation of a Kotlin query DSL for a GraphQL Schema

#### schema-creator
* Responsible for creating a GraphQL file (.gql) from a `GraphQLSchema` model from the **core** module
* Turns a Kotlin class into a GraphQL Schema
* Depends on the **core** module
* Can be called from an annotation processor, build system plugin, or compiler plugin to generate a GraphQL Schema

#### schema-dsl
* A convenience Kotlin DSL for creating a `GraphQLSchema` model from the **core** module