package com.mr_praveen_jha_.structuredcoroutines

import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO

class UserDataManager2 {


    // structured concurrency


    suspend fun getUserDataCount() : Int {
        var count = 0
        lateinit var defered : Deferred<Int>
        coroutineScope {
            launch (IO){
                    delay(1000)
                count = 50
            }

            defered =async(IO) {
                delay(3000)
                return@async 70
            }
        }
        return count+defered.await()
    }
}