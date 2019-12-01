## schema-dsl

A Kotlin library providing a DSL for creating a GraphQL Schema. This library provides the ability to create a `GraphQLSchema`, and other related types, from the **core** module, using a Kotlin DSL.

For example, consider the following GraphQL Schema:

```graphql
schema {
  query: Query
}

type Query {
  hero(episode: Episode): Character
}

type Character {
  name: String!
  appearsIn: [Episode!]!
}

enum Episode {
  NEWHOPE
  EMPIRE
  JEDI
}
```

The above GraphQL Schema could be written as a Kotlin DSL, with this library, like this:

```kotlin
val episodeEnum = enum("Episode") {
    +"NEW_HOPE"
    +"EMPIRE"
    +"JEDI"
}
    
val characterObject = outputObject {
    name = "Character"

    fields {
        field {
            name = "name"
            type = GraphQLString.asNonNull()
        }
        field {
            name = "appearsIn"
            type = episodeEnum.asNonNull().asList().asNonNull()
        }
    }
}
    
schema {
    query {
        name = "Query"
            
        fields { 
            field { 
                name = "hero"
                arguments { 
                    argument { 
                        name = "episode"
                        type = episodeEnum
                    }
                }
                type = characterObject
            }
        }
    }
}
```

Alternatively, the above GraphQL Schema could be written in Kotlin without this DSL library, using the **core** module, like this:

```kotlin
val episodeEnum = GraphQLEnumType(
        name = "Episode",
        values = listOf(
                GraphQLEnumValue(name = "NEW_HOPE", value = 0),
                GraphQLEnumValue(name = "EMPIRE", value = 1),
                GraphQLEnumValue(name = "JEDI", value = 2))
)

val characterObject = GraphQLObjectType(
        name = "Character",
        fields = listOf(
                GraphQLField(name = "name", type = GraphQLString.asNonNull()),
                GraphQLField(name = "appearsIn", type = episodeEnum.asNonNull().asList().asNonNull()))
)

GraphQLSchema(
        queryType = GraphQLObjectType(
                name = "Query",
                fields = listOf(
                        GraphQLField(name = "hero", type = characterObject, arguments = listOf(
                                GraphQLArgument(name = "episode", type = episodeEnum))))
        )
)
```