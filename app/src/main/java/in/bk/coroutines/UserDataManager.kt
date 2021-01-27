package `in`.bk.coroutines

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class UserDataManager {


    //Returned value supposed to be 50. But we received 0. Here this coroutine scope crates a new coroutine, which behaves separately from this parent coroutine in the main activity.
    // Unstructured Concurrency Does not guarantee to complete all the tasks of the suspending function, before it returns.
    suspend fun getTotalUserCount(): Int {
        var count = 0
        CoroutineScope(IO).launch {
            delay(1000)
            count = 50
        }
        return count
    }


    // with async builder and await function // will return the exact value
    suspend fun getTotalUserCount2(): Int {
        var count = 0
       val deferred= CoroutineScope(IO).async {
            delay(1000)
           return@async 70
        }
        return count+deferred.await()
    }

/**-Does this means, unstructured concurrency is ok, with async builders.
 No, still there are problems.You know, In android if there is an error happen in a function, the function throws an exception.

-So we can catch the exception in the caller function and handle the situation. In unstuructured comcurrency
 weather we use lauch or async builders ,

-there is no way to properly handle exceptions. So, even though is seems work well in some scenarios ,
 it is not recommended to use unstructured concurrency.
*/
}