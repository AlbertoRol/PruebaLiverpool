package com.alberto.pruebaliverpool.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.alberto.pruebaliverpool.data.model.Record
import com.alberto.pruebaliverpool.domain.GetProductUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(
    private var getProductUseCase: GetProductUseCase) : ViewModel() {

    fun getProduct(): Flow<PagingData<Record>> = getProductUseCase().cachedIn(viewModelScope)
}