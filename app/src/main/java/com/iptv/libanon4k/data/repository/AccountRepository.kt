package com.iptv.libanon4k.data.repository

import com.iptv.libanon4k.data.local.dao.AccountDao
import com.iptv.libanon4k.data.local.dao.CategoryDao
import com.iptv.libanon4k.data.model.Account
import com.iptv.libanon4k.data.model.Category
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AccountRepository @Inject constructor(
    private val accountDao: AccountDao,
    private val categoryDao: CategoryDao
) {

    fun getAllAccounts(): Flow<List<Account>> = accountDao.getAllAccounts()

    fun getActiveAccount(): Flow<Account?> = accountDao.getActiveAccountFlow()

    suspend fun addAccount(account: Account) {
        accountDao.deactivateAllAccounts()
        accountDao.insertAccount(account)
    }

    suspend fun updateAccount(account: Account) {
        accountDao.updateAccount(account)
    }

    suspend fun deleteAccount(account: Account) {
        accountDao.deleteAccount(account)
        categoryDao.deleteCategoriesByAccount(account.id)
    }

    suspend fun switchAccount(accountId: Long) {
        accountDao.deactivateAllAccounts()
        accountDao.activateAccount(accountId)
    }

    suspend fun getAccountById(id: Long): Account? = accountDao.getAccountById(id)
}
