package com.alberto.pruebaliverpool.data.model

data class RefinementGroup(
    val dimensionName: String,
    val moreRefinements: Boolean,
    val multiSelect: Boolean,
    val name: String,
    val refinement: List<Refinement>
)