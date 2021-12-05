package com.system.assignment.data.local

import com.system.assignment.data.local.entity.User
import io.reactivex.Observable

interface DatabaseHelper {

    fun getAllUsers(): List<User?>
    fun insertUser(user: User)

}