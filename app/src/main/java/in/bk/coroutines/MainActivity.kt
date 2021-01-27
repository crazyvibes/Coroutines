package `in`.bk.coroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main

class MainActivity : AppCompatActivity() {
    private var count = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCount.setOnClickListener {
            tvCount.text = count++.toString()

        }
        btnDownloadUserData.setOnClickListener {

//            CoroutineScope(Dispatchers.IO).launch {
//              //  downloadUserData2()
//            }
                //for unstructured concurrency
            CoroutineScope(Dispatchers.Main).launch {
                tvUserMessage.text = UserDataManager().getTotalUserCount2().toString()
            }


        }


        //        btnDownloadUserData.setOnClickListener {
//
//            CoroutineScope(Dispatchers.Main).launch {
//                downloadUserData()
//            }
//
//        }


        //without async and await(synchronously)

//        CoroutineScope(IO).launch {
//            Log.i("TAG", "Calculation is started")
//            val stock1=getStock1()
//            val stock2=getStock2()
//            val total=stock1+stock2
//            Log.i("TAG", "Total is $total")
//        }

        //with async and await(synchronously)

//        CoroutineScope(IO).launch {
//            Log.i("TAG", "Calculation is started")
//            val stock1=async { getStock1() }
//            val stock2=async { getStock2() }
//            val total=stock1.await()+stock2.await()
//            Log.i("TAG", "Total is $total")
//        }


        //with main
//        CoroutineScope(Main).launch {
//            Log.i("TAG", "Calculation is started")
//            val stock1=async(IO) { getStock1() }
//            val stock2=async(IO) { getStock2() }
//            val total=stock1.await()+stock2.await()
//            Toast.makeText(applicationContext,"Total is $total",Toast.LENGTH_LONG).show()
//            //Log.i("TAG", "Total is $total")
//        }
    }

    private fun downloadUserData() {
        for (i in 1..200000) {
            Log.i("MyTag", "Downloading user $i in ${Thread.currentThread().name}")
        }
    }

    private suspend fun downloadUserData2() {  //showing result on ui intead of log by  using suspend and withContext
        for (i in 1..200000) {
            withContext(Dispatchers.Main) {

                // Log.i("MyTag", "Downloading user $i in ${Thread.currentThread().name}")
                tvUserMessage.text = "Downloading user $i in ${Thread.currentThread().name}"
            }
        }

    }


    private suspend fun getStock1(): Int {
        delay(10000)
        Log.i("TAG", "stock1 returned")
        return 55000
    }

    private suspend fun getStock2(): Int {
        delay(8000)
        Log.i("TAG", "stock2 returned")
        return 55000
    }
}