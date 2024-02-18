package com.alberto.pruebaliverpool.data.model

data class PlpResults(
    val enableMinNumOfPieces: Boolean,
    val label: String,
    val metaData: MetaData,
    val navigation: Navigation,
    val plpState: PlpState,
    val records: List<Record>,
    val redirectTo404: Boolean,
    val refinementGroups: List<RefinementGroup>,
    val sortOptions: List<SortOption>
)