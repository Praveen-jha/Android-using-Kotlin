package com.mr_praveen_jha_.structuredcoroutines

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class UserDataManager {


    // CoroutineScope           ------>  this is an interface this allows to create a child coroutine within a coroutine scope
    //                                   this scope gurentee the complition of the task when the suspending function returns


    // coroutineScope           ------> this is an suspending function


    /**
     * this functions create a coroutine and assign the count value
     * as 0 and end the coroutines  this functions doesnot wait for
     * the delay then complete the work, before the completion of
     * the all task it return the value as 0
     */


    /**
     * this is the unstructured concorrency and it does not take
     * gurantee to complete the whole the task before it return
     * child coroutines can be still running even of the completion
     * of the parent coroutine.
     */

//    suspend fun getTotalUserCount() : Int{
//
//        var count = 0
//
//        CoroutineScope(IO).launch {
//            delay(1000)
//            count = 50
//        }
//        return count
//    }

    suspend fun getTotalUserCount(): Int {

        var count = 0

        CoroutineScope(IO).launch {
            delay(1000)
            count = 50
        }


        // creating another coroutine using ASYNC


        val defered = CoroutineScope(IO).async {
            delay(3000)
            return@async 70
        }

        /**
         * when the first coroutine complete and return 0 as value
         * then it has to wait for 3 sec for the next coroutine
         * then another coroutine will return the value 70
         * then it return the 0+70 = 70
         */
        return count + defered.await()

    }


}