package com.mr_praveen_jha_.structuredcoroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        CoroutineScope(Main).launch {
//            tvText.text = UserDataManager().getTotalUserCount().toString()
//            Log.d("MyTag"," value is ${UserDataManager().getTotalUserCount()}")
//
//        }


        CoroutineScope(Main).launch {
            tvText.text = UserDataManager2().getUserDataCount().toString()
            Log.d("MyTag"," value is ${UserDataManager2().getUserDataCount()}")

        }
    }
}