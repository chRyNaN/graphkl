package com.chrynan.graphkl.language.node

/**
 *  A [SelectionNode] represents a "Selection".
 * "Selections" are the definitions that can appear legally and at
 * single level of the query. These include:
 * 1) field references e.g "a"
 * 2) fragment "spreads" e.g. "...c"
 * 3) inline fragment "spreads" e.g. "...on Type { a }"
 */
interface SelectionNode : Node