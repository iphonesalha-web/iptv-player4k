package com.iptv.libanon4k.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.iptv.libanon4k.data.model.Category
import kotlinx.coroutines.flow.Flow

@Dao
interface CategoryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCategory(category: Category)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCategories(categories: List<Category>)

    @Update
    suspend fun updateCategory(category: Category)

    @Delete
    suspend fun deleteCategory(category: Category)

    @Query("DELETE FROM categories WHERE accountId = :accountId")
    suspend fun deleteCategoriesByAccount(accountId: Long)

    @Query("SELECT * FROM categories WHERE id = :id")
    suspend fun getCategoryById(id: String): Category?

    @Query("SELECT * FROM categories WHERE accountId = :accountId AND type = :type ORDER BY id ASC")
    fun getCategoriesByType(accountId: Long, type: String): Flow<List<Category>>

    @Query("SELECT * FROM categories WHERE accountId = :accountId ORDER BY id ASC")
    fun getCategoriesByAccount(accountId: Long): Flow<List<Category>>
}
