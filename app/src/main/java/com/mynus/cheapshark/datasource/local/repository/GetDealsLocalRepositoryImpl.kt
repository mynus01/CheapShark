package com.mynus.cheapshark.datasource.local.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.mynus.cheapshark.datasource.local.dao.DealDao
import com.mynus.cheapshark.datasource.local.paging.DealsLocalPagingSource
import com.mynus.cheapshark.domain.model.Deal
import com.mynus.cheapshark.domain.repository.GetDealsLocalRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetDealsLocalRepositoryImpl @Inject constructor(
    private val dao: DealDao
): GetDealsLocalRepository {
    override suspend fun get(): Flow<PagingData<Deal>> {
        return Pager(
            config = PagingConfig(
                pageSize = 60,
                enablePlaceholders = true
            ),
            pagingSourceFactory = { DealsLocalPagingSource(dao) }
        ).flow
    }
}