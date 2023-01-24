package com.mr_praveen_jha_.coroutinesviewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mr_praveen_jha_.coroutinesviewmodel.Model.User
import com.mr_praveen_jha_.coroutinesviewmodel.Model.UserRepository
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO

class MainActivityViewModel : ViewModel(){

    private var userRepository = UserRepository()
    var users: MutableLiveData<List<User>> = MutableLiveData()

 fun getUserData(){
     viewModelScope.launch{
         var result : List<User>? = null
         withContext(Dispatchers.IO){
             result = userRepository.getUsers()
         }

         users.value = result!!
     }
 }







//    private val myJob = Job()
//    private val myScope = CoroutineScope(IO)
//
//    fun getUserData(){
//        myScope.launch {
//            // write some code
//        }
//    }
//
//    override fun onCleared() {
//        super.onCleared()
//        myJob.cancel()
//    }


//    instead of this we can use viewModelScope
}