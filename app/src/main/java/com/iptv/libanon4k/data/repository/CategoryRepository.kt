package com.iptv.libanon4k.data.repository

import com.iptv.libanon4k.data.local.dao.CategoryDao
import com.iptv.libanon4k.data.model.Category
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CategoryRepository @Inject constructor(
    private val categoryDao: CategoryDao
) {

    fun getCategoriesByType(accountId: Long, type: String): Flow<List<Category>> =
        categoryDao.getCategoriesByType(accountId, type)

    fun getCategoriesByAccount(accountId: Long): Flow<List<Category>> =
        categoryDao.getCategoriesByAccount(accountId)

    suspend fun insertCategories(categories: List<Category>) {
        categoryDao.insertCategories(categories)
    }

    suspend fun getCategoryById(id: String): Category? = categoryDao.getCategoryById(id)
}
