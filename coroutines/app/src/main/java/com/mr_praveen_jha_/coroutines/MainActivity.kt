package com.mr_praveen_jha_.coroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main

class MainActivity : AppCompatActivity() {
    var count = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCount.setOnClickListener {
            tvCount.text = count++.toString()
        }

        btnDownload.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                downloadUserData()
            }
        }


        /**
         *  function stock1 will take 10 seconds and return its value
         *  then stock2 fun will take 10 seconds and return its value
         *  after 20 seconds we will get the output
         */
//        CoroutineScope(IO).launch {
//            Log.d("MyTag","Calculation started")
//            val stock1 = getStock1()
//            val stock2 = getStock2()
//            val total = stock1+stock2
//            Log.d("MyTag","total = $total")
//        }


        /**
         * but when we use async then both stock1 and stock2 functions
         * will run at the same time parallaly and return the result
         * in 10 seconds only
         */

//        CoroutineScope(IO).launch {
//            Log.d("MyTag","Calculation started")
//            val stock1 = async {getStock1()}
//            val stock2 = async { getStock2() }
//            val total = stock1.await()+stock2.await()
//            Log.d("MyTag","Total is $total")
//
//        }
        /**
         *  we can also make a main thread on MAIN Thread and
         *  call both the coroutines of async on IO thread
         *  like this
         */


        CoroutineScope(Main).launch {
            Log.d("MyTag","Calculation started")
            val stock1 = async(IO) {getStock1()}
            val stock2 = async(IO) { getStock2() }
            val total = stock1.await()+stock2.await()
            Log.d("MyTag","Total is $total")

            // we can show the toast only on the main thread..
            Toast.makeText(applicationContext, "total result is $total", Toast.LENGTH_SHORT).show()

        }
    }


    private  suspend fun downloadUserData() {
        for (i in 1..200000000) {
            withContext(Dispatchers.Main) {
                tvdownload.text = "Download $i in ${Thread.currentThread().name}"
            }
        }
    }




    private suspend fun getStock1() : Int{
        delay(10000)
        Log.d("MyTag","Stock 1 returned")
        return 100
    }
    private suspend fun getStock2() : Int{
        delay(10000)
        Log.d("MyTag","Stock 2 returned")
        return 100
    }
}