package com.system.assignment.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.system.assignment.data.local.entity.User
import com.system.assignment.data.repository.DataManager
import com.system.assignment.ui.base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject


class MainActivityViewModel @Inject constructor(
    private val dataManager: DataManager
) : BaseViewModel() {

    var listen = MutableLiveData<ArrayList<User>>()

    init {
        fetchUsers()
    }

    private fun fetchUsers() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val database: ArrayList<User> = dataManager.getAllUsers() as ArrayList<User>
                dataManager.getUsers().results.forEachIndexed { index, results ->
                    database.add(0, User(results.login!!.uuid!!, results.name!!.title, results.email, results.picture!!.large,false, true))
                }
                listen.postValue(database)
            }
        }
    }

    fun saveRecord(user: User, status: Boolean) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                user.status = status
                user.newUser = false
                dataManager.insertUser(user)
            }
        }
    }

}