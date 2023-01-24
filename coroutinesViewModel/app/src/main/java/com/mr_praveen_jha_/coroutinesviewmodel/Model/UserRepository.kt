package com.mr_praveen_jha_.coroutinesviewmodel.Model

import kotlinx.coroutines.delay

class UserRepository {

    suspend fun getUsers() :List<User> {
        delay(8000)
        val users: List<User> = listOf(
            User(1,"Praveen"),
            User(2,"Tania"),
            User(3,"Tanu"),
            User(4,"Tommy"),
        )
        return users
    }
}