package `in`.bk.coroutines

import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO

class UserDataManger2 {
    var count = 0
    lateinit var deferred:Deferred<Int>
    suspend fun getTotalUserCount(): Int {
       coroutineScope {
        launch(IO) {
            delay(1000)
            count = 50
        }

            deferred= async(IO) {
               delay(1000)
               return@async 70
           }
       }
        return count+deferred.await()
    }

    /**
    -So this is the recommended best practice. When you have more than one coroutines, you should always start with
    the Dispatchers.Main . You should always start with the CoroutineScope interface. And inside suspending functions
    you should use coroutineScope function which starts with the simple 'c' to provide a child scope.

    -So this is structured concurrency. Structured concurrency guarantees to complete all the work started
    by coroutines, within the child scope, before the return of the suspending function. Actually

    -This coroutineScope Wait for the child coroutines to complete. Not only that ,there are other benefits of this structured concurrency.

    -When errors happen, when exceptions thrown, structured concurrency guarantees to notify the caller*/
}