## query-dsl-builder

This module provides a way to create GraphQL Queries using a Kotlin DSL.

Consider the following GraphQL Query:

```graphql
query HeroNameAndFriends {
    hero(id: "1234") {
        name
        friends {
            name
        }
    }
}
```

Which can be created with a Kotlin DSL using this library, like so:

```kotlin
graphQL {
    query("HeroNameAndFriends") {
        field("hero", "id" to "1234") {
            field("name")
            field("friends") {
                field("name")
            }
        }
    }
}
```

## Library Usage

### [Fields](https://graphql.org/learn/queries/#fields)

Scalar Field:
```kotlin
field(name = "scalarField")
```

Scalar Field with Arguments:
```kotlin
field("scalarField", "arg1" to "1", "arg2" to 2)

// OR

field(name = "scalarField", args = mapOf("arg1" to "1", "arg2" to 2))
```

Object Field:
```kotlin
field(name = "objectField") {
    field("scalarField")
}
```

Object Field with Arguments:
```kotlin
field("objectField", "arg1" to "1", "arg2" to 2) {
    field("scalarField")
}

// OR

field(name = "objectField", args = mapOf("arg1" to "1", "arg2" to 2)) {
    field("scalarField")
}
```

### [Aliases](https://graphql.org/learn/queries/#aliases)

```kotlin
field(name = "hero", alias = "empireHero", args = mapOf("episode" to EMPIRE))
```

### [Fragments](https://graphql.org/learn/queries/#fragments)

Declaring Fragments on a GraphQL Query:
```kotlin
graphQL {
    // Returns a GraphQLQueryFragment for using later
    fragment(name = "comparisonFields", on = "Character") {
        field("name")
        field("appearsIn")
        field("friends") {
            field("name")
        }
    }
}
```

Using a declared Fragment:
```kotlin
fromFragment("comparisonFields")

// OR

fromFragment(declaredFragmentObject)
```

### [Inline Fragments](https://graphql.org/learn/queries/#inline-fragments)

```kotlin
inlineFragment(on = "Droid") {
    field("primaryFunction")
}
```

### [Operation Name](https://graphql.org/learn/queries/#operation-name)

```kotlin
query(operationName = "HeroNameAndFriends") { ... }
```

### [Variables](https://graphql.org/learn/queries/#variables)

Defining Variables on a Query:
```kotlin
query {
    variableDefinition(name = "episode", typeName = "Episode", defaultValue = JEDI)
}
```

Providing Variable Values in a Query:
```kotlin
graphQL {
    variable(name = "episode", value = JEDI)
}
```

### [Directives](https://graphql.org/learn/queries/#directives)

```kotlin
field(name = "friends", directives = listOf(directive("include", "if" to false)))
```

### [Mutations](https://graphql.org/learn/queries/#mutations)

```kotlin
mutation(operationName = "CreateReviewForEpisode") {
    variableDefinition(name = "ep", typeName = "Episode!")
    variableDefinition(name = "review", typeName = "ReviewInput!")
    field("createReview", "episode" to "\$ep", "review" to "\$review") {
        field("stars")
        field("commentary")
    }
}
```

## Getting the GraphQL Query String

* For a String used in a GraphQL HTTP request, use the `GraphQLQuery.toRequestString()` function.
* For a String used in a Log file or for debugging, use the `GraphQLQuery.toPrettyString()` function.

Example:
```kotlin
val query = graphQL {
    query("HeroNameAndFriends") {
        field("hero", "id" to "1234") {
            field("name")
            field("friends") {
                field("name")
            }
        }
    }
}

query.toRequestString()
// query HeroNameAndFriends { \n hero(id: "1234") { \n name \n friends { \n name \n } \n } \n }

query.toPrettyString()
// query HeroNameAndFriends {
//     hero(id: "1234") {
//         name
//         friends {
//             name
//         }
//     }
// }
```

## Kotlin DSL Builder Wrapper Classes

This library could be wrapped in more specific Kotlin DSL Builders to provide an extra layer of type safety. A library might even be able to be created that would auto-generate these builders.

### Wrapped Fields

Scalars:
```kotlin
val name: Unit
    get() = builder.field("name")
```

Scalars with arguments:
```kotlin
fun date(format: String) {
    builder.field("date", "format" to format)
}
```

Objects:
```kotlin
fun friends(config: MyBuilder.() -> Unit) {
    builder.field("friends") {
        // "this" referring to the GraphQLQueryFieldObjectBuilder instance from the "field" function
        config.invoke(MyBuilder(this))
    }
}
```

Objects with arguments:
```kotlin
fun hero(id: ID, config: MyBuilder.() -> Unit) {
    builder.field("friends", "id" to id) {
        // "this" referring to the GraphQLQueryFieldObjectBuilder instance from the "field" function
        config.invoke(MyBuilder(this))
    }
}
```