package `in`.bk.coroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    private var count = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCount.setOnClickListener {
            tvCount.text = count++.toString()

        }
        btnDownloadUserData.setOnClickListener {

            CoroutineScope(Dispatchers.IO).launch {
                downloadUserData2()
            }

        }



//        btnDownloadUserData.setOnClickListener {
//
//            CoroutineScope(Dispatchers.Main).launch {
//                downloadUserData()
//            }
//
//        }
    }

    private fun downloadUserData() {
        for (i in 1..200000) {
            Log.i("MyTag", "Downloading user $i in ${Thread.currentThread().name}")
        }
    }

    private suspend fun downloadUserData2() {  //showing result on ui intead of log by  using suspend and withContext
        for (i in 1..200000) {
        withContext(Dispatchers.Main){

               // Log.i("MyTag", "Downloading user $i in ${Thread.currentThread().name}")
                tvUserMessage.text="Downloading user $i in ${Thread.currentThread().name}"
            }
        }

    }
}