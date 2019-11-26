package com.chrynan.graphkl.language.type.scalar

import com.chrynan.graphkl.language.type.GraphQLScalarType

sealed class DefaultGraphQLScalarType(
        name: String,
        description: String? = null
) : GraphQLScalarType(name = name, description = description)

object GraphQLInt : DefaultGraphQLScalarType(
        name = "Int",
        description = "The `Int` scalar type represents non-fractional signed whole numeric values. Int can represent values between -(2^31) and 2^31 - 1."
)

object GraphQLFloat : DefaultGraphQLScalarType(
        name = "Float",
        description = "The `Float` scalar type represents signed double-precision fractional values as specified by [IEEE 754](https://en.wikipedia.org/wiki/IEEE_floating_point)."
)

object GraphQLString : DefaultGraphQLScalarType(
        name = "String",
        description = "The `String` scalar type represents textual data, represented as UTF-8 character sequences. The String type is most often used by GraphQL to represent free-form human-readable text."
)

object GraphQLBoolean : DefaultGraphQLScalarType(
        name = "Boolean",
        description = "The `Boolean` scalar type represents `true` or `false`."
)

object GraphQLID : DefaultGraphQLScalarType(
        name = "ID",
        description = "The `ID` scalar type represents a unique identifier, often used to refetch an object or as key for a cache. The ID type appears in a JSON response as a String; however, it is not intended to be human-readable. When expected as an input type, any string (such as `\"4\"`) or integer (such as `4`) input value will be accepted as an ID."
)