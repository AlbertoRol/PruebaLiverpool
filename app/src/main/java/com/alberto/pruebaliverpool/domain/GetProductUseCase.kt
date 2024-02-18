package com.alberto.pruebaliverpool.domain

import androidx.paging.PagingData
import com.alberto.pruebaliverpool.data.model.ProductItem
import com.alberto.pruebaliverpool.data.model.Record
import com.alberto.pruebaliverpool.data.repository.ProductRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetProductUseCase @Inject constructor(
    private val repository: ProductRepository
){
     operator fun invoke(): Flow<PagingData<Record>> {
        return repository.getProductRepository()
    }
}