package com.alberto.pruebaliverpool.data.repository

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.alberto.pruebaliverpool.data.constant.Constant
import com.alberto.pruebaliverpool.data.model.Record
import com.alberto.pruebaliverpool.data.network.service.ProductService
import javax.inject.Inject

class NewsPagingSource @Inject constructor(
    private val productService: ProductService
): PagingSource<Int, Record>() {
    override fun getRefreshKey(state: PagingState<Int, Record>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Record> {
        return try {
            val page = params.key?: 0
            val response = productService.getProduct(page_number = page, search = Constant.busqueda, sort = Constant.order, force = false, numberitems = params.loadSize, clean = false )

            LoadResult.Page(
                data = response.plpResults.records,
                prevKey = if (page == 0)  null else page-1 ,
                nextKey = if (response.plpResults.records.isEmpty()) null else page+1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}