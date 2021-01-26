# Coroutines
This is a demo project to cover all concept of coroutines.

-In computer science there are two types of multitasking methods to manage multiple concurrent processes .
 In one type the operating system controls the switch between processes.

-The other type is called cooperative multitasking, in which processes control their behavior by themselves.
 Coroutines are software components that creates sub routines for cooperative multitasking.

-Coroutines were first used in 1958 for the assembly language. Developers of modern programming lauguages such as
 python, javascript and c# have been using coroutines for many years. 


-In Kotlin a corotine can be introduced as a sequence of well managed “sub-tasks” . 
 To some extent a coroutine can be considered as a light weight thread.

-You can execute many coroutines in a single thread. A coroutine can also be switched between threads.
 That means a coroutine can be suspended form one thread and resumed from another thread.

-As android developers , with the relese kotlin 1.3 we now have a fully stable corotines api.
 All the painful multithreading tasks done with rxjava, asynctask or other methods such as executors,
 HandlerThreads and IntentServices can be easily and efficiently done with Corotuines .
 done with Corotuines . 

-Coroutines API also allows us to write asynchronous codes in a sequential manner.
 Hense it avoids unnecessary boilderpalate codes comes with callbacks and makes our codes more readable
 and maintainable.

-Before code our our first coroutine, let’s very quickly discuss why we need asynchronous programming in android developemt

##Asynchronous programing

-Most of the smart phones has a refresh frequency of at least 60hz. For 1 second or for
 1000 milliseconds,

-the app refreshes 60 times.
 Let’s divide 1000 milliseconds by 60.
 It is 16.666… repeating

-So , if our app runs in this phone it has to draw the screen
 using main thread approximately every 16 seconds.

-But we already have better smart phones available in the market with
 higher refresh rates such as 90hz , 120hz .

-If the phone has a refresh level of 90hz , Let’s devide 1000 milliseconds by 90
 our app has only 11 ms to perform tasks in the Android main thread.

-If the refresh level is 120hz, 1000 devide by 120
 our app will have only 8 ms. By default android main thread has a set of regular responsibilities.

-It has to always parse xml, inflate view components and draw them again and again for every refresh.
 Main thread also has to deal with user interactions such as click events.

-So, If we add more tasks to the main thread, if its execution time exceeds this super small time gap between
 two refreshes, app will show performance errors. Screen might freeze. User will see unpredictable behaviours
 in view components. It will even cause application not responding error.

-As a result of technological advancements, these refresh rates getting higher and higher every year.
 Therefore , as android developers we should always try to execute long running tasks asynchronously
 in a separate thread. 

-To achieve that , newest, most efficient and most effective technology we have today is

Kotilin Coroutines.

##Coroutine Demo

-To save your valuable time, and to make this lesson less boring I created a new android studio project,
 I named it as CoroutinesDemo1.

-I also did some coding .
 You can download this project from the resources of this lesson.

-It is there as the starter project of this lesson. If you download it now and open it with your android studio, you will be able to code with me.
 Coding with me is really important to learn and understand these lessons. 

-Let’s very quickly go through the code. Here in the manactivity_xml, I added two buttons and two text views.

-Id of this button is btnDownloadUserData, Id of this button is btnCount

-Ids of textviews are tvUserMessage and tv count. You can study the xml here.

-Now, let’s switch to main activity.
 Here I have defined a variable to keep track of counts and assigned 0 as the initial value.

-This is the onClicklistener of the count button.

-Every time the use clicks on this count button , value of the cournt variable will increase by one and the new
 values will be displayed on the textview. Let me run the app and show you.
 Like this. Then This is the onClickListener of downloadUserData button.

-When the use click on this button, it will call to this downloadUserData function and a for loop
 will start iterating for 200000 times. And I have also added a log statement to see the iteration count and the current executing thread.

-I added this download user data button to simulate a long running task. In a real app, this might represent
 downloading user data from a server.


-So, this is the code I created.. I hope code is 100% clear to you. In course description of this
 course I described that this course is for experienced android developers. But if you are a beginner
 level android developer it doesn’t matter.


-Now, this is what we are going to do.

-We are going to first click on this download user data button to start a long running task. And then
 at the same time we are going to click on count button.

-So we are going to simulate two processes in the main thread. So , let’s run app and have a look.
 Now I am going to click on download user data button first to start the for loop which simulates
 a heavy , long running task . and then click on this click here button to get the click count. 

-We supposed to see click count values progressing one by one as one , 
 two three and eventually move to ten. But we saw only 10 after a little wait.

-That means , our app was temporary freezing.

-You can see here the thread name is Main

-This User interface issue happened as a result of executing a heavy long-running task in the main thread. So it’s time to create our first co routine.
 so, to avoid that, to execute this in a separate thread, it's time to create our first coroutine.

-I have a question for you ?
 Are co routines and threads same?
 No, we have Main or UI thread.

-We also have on demand back ground worker threads.

-But threads are not equal to coroutines.
 Any one of Any one of those threads can have
 many co routines executing in it at the same time

-One thread can have many co routines running in that thread.

-Coroutines are like just separate processors running on a thread. So, In order to use co routines,
 first of all we need to add coroutines dependencies to the app level gradle file.
 You can find them from this official Kotlinx Coroutines github page. We need to add both core and
 android dependencies.

-This core dependency provides Main API for coroutines in Kotlin. And this Android dependency provides
 support to work with Android related components .

-Then ,Click on sync now. Let’s start with CoroutineScope. CoroutineScope is an interface provides
 the scope of the coroutine.

-We will talk more about CoroutineScope during the next lesson. Then we need to provide the context. All the
 co routines going to start within this scope will be run on this context.

-We need to run this task in a background thread So let’s provide Dispatchers.IO
 For now, let’s just include this.

-I will teach you everything about dispatchers during the next lesson. Dot launch . Launch is the coroutine builder.
 Now, this will create a co routine.

-Let move this downloadUserData function call to the co routine.

-So now this function will execute inside our new coroutine.
 All right, That’s it Congratulations. You created your first coroutine. See, how simple it is.

-Let’s run the app and see how this works.good, as we expected the click count button working properly
 without any unexpected delay.

-So we just created our first co routine.
 I know, by now you might have a lot of questions. There are a lot of
 new words. CoroutineScope, dispatchers, launch.


##Coroutines fundamentals:

-we can launch many corouintes, there can be even hundred coroutines running at the same time. But, by default
 coroutines don’t help us to keep track of them, or keep track of any work that’s being done by them.

-If we do not manage them very carefully , there can be coroutine leasks in the memory.
 Resources will be unnecessarily waste and it will also affect to the performance of the application.
 But lucky for us , Kotlin programming language creators has already fixed that problem .

-In Kotlin Koroutines, we have to, we must start all the coroutines within a scope. Using the properties
 belong to the scope we can easily keep track of coroitnes, cancel coroitnes and handle errors or exceptions
 thrown by the coroutines.

-So, this CoroutineScope is the interface we have used to provide the scope to our coroutine.

-In Kotlin Koroutines
 we have another scope interface called GlobalScope. Global scope is used to launch top-level coroutines
 which are operating on the whole application lifetime . In android development we very rarely use
 GlobalScope .

-Both of These scopes also acts as a reference to the coroutine context.
 So, this is the context of our CoroutineScope. For this context
 
-we have only used a dispatcher as the context. If we want to use an explicit job instance, 
 we can include the name of the Job instance plus a Dispatcher as the context for the scope .

-The plus operator can be used to merge multiple coroutine contexts
 We will study about Jobs ,very soon. 

-Dispatcher describes the kind of thread where the coroutine
 should be run. In Kotlin Android structured concurrency,

-it is always recommended to start coroutines using main thread and then switch to background threads. 

-To lauch coroutines in the main thread
 we use Dispatcher.Main.
 We also have IO dispatcher.
 Dispatcers.IO, Dispatchers.Default and
 Dispatchers.Unconfined.

-So, If we use Dispatcher.Main , the coroutine will run in the Main Thread. In android we also call it UI thread.
 You know, there is only one Main or UI thread.

-So if you create 10 coroutines within a scope with Dispatchers.Main as the context,
 All those 10 coroutines will run in the same Main thread.

-We only use main dispatcher for small, light weight tasks like call to a ui function, call to a suspending
 function or to get updates from the livedata. In structured concurrency , Recommended best practice is
 always starting a coroutine from the Main thread and later switching it to a 
 background thread . We will learn all those things very soon.

-If we use Dispatchers.IO, the coroutine will run in a background thread from a shared pool of on-demand
 created threads. We use this IO dispatcher to work with local database, communicate with network and to work with files. 
 
-Default dispatcher is used for CPU intensive tasks such as sorting a list of data with 10000 list items , 
 or parsing a huge JSON file with details of 100000 movies.

-Dispatcher.Uncomfined is a dispatcher used with GlobalScope.

-If we use Dispatchers.Unconfined Coroutine will run on the current thread, but if it is suspended and resumed,
 it will run on whichever thread that the suspending function is running on. It is not recommended to use
 this dispatcher for Android Development.

-Apart from these 4 dispatchers coroutines API also facilitates us to convert executors in to dispatchers
 as well as to create our own custom dispatchers. Creators of libraries like room and retrofit, have
 been using there own custom dispatchers to execute operations in a separate background thread.

-Therefore , you will see, when we use retrofit and room, we can easily use them from the main dispatcher.
 Without writing codes to change the thread. As android developers most of the time we use Dispatchers.Main and Dispathcers.IO . 

-Now, Let’s go back to our code again. This launch is the coroutine builder. Coroutine builders are 
 extension functions of coroutine scopes, which are used to launch a new coroutine . 

-There are four main coroutine builders. Launch, async, produce and runblocking. 

-Launch coroutine builder launches a new co routine without blocking the current thread.

-This builder returns an instance of job which can be used as a reference to the co routine. We can use that
 We can use that returned job instance to keep track of the co routine and to cancel the coroutine. 
 We use launch builder for coroutines that does not have any result as the return value. 
 This builder returns a Job instance but does not return any computational result,

-we cannot use this coroutine to calculate something and get the final answer as the returned value.

-If we want get such result as a returned value we should use async coroutine builder.
 Not only that, the main specialty of async builder is that it allows us to launch coroutines in paralle. 

-Async builder also launches a new coroutine without blocking the current thread.

-This builder returns an instance of deferred of type of the result. Actually deferred interface is
 an extension of job interface. So we can use it like we use job for things link cancelling a coroutine.

-If our result is a string value the type would be string, If our result is an Int value
 This type would be Int. Like that. To get the value from the deferred object,

-we need to invoke its await() function. 

-In android development Launch and Async builders are the coroutine builders
 we use most of the time. But we also have Produce and runBlocking builders. 

-Produce builder is for coroutines which produces a stream of elements .
 This builder returns an instance of ReceiveChannel. 

-In Android development we use runblocking builder , mostly for testing.
 Not like other coroutines, the coroutine we create using this builder will block the thread until its execution is over. 
 And it returns a result which we can directly use.

-Well, what is structured concurrency. Structured Concurrency is a set of lauguage features and best practices
 introduced for Kotlin Coroutines to avoid corutines leaks and manage coroutines productively.

-We have a separate lesson dedicated to introduce structured concurrency . And we will do a lot of coding
 following structured concurrency during this course. But during these earlier lessons,
 until you get familiar with basic concepts we will just do our coding in a unstructured manner.
 
 
## switch thread in coroutines


-Here, we have created two buttons. When we click on this download user data button
 it launches a co routine in a background thread and starts a long-running process.

-Here we have written codes for that.

-And when we click on the click here button, we can see the number of clicks on the screen.

-These are the codes we wrote for that process which we created during that previous lesson. Let’s run the app
 So this is how app works

-Now during this lesson we are going to move one step forward and show these results on the user interface. Instead of
 logging them we will display them in a TextView. We alrady have a TextView included
 to the activity_main.xml file for that task with the id tvUserMessage.

-Now in this example our long running task executes in a background thread. And we are going to display
 the message

-If we write codes to display the message in the textView like this.
 You know it will not work. 

-In Android.
 we cannot directly call to a view component running in ui thread from a background thread like this.

-If we run this app now , it will crash showing a CalledFromWrongThreadException .

-Only the original thread that created a view hierarchy can touch its views.

-Therefore we have to call views from the UI thread.But fortunately coroutines has the easiest way to switch
 between threads. Using with context function we can switch a coroutine from one thread to another.

-Let me show you how to do it. withContext
 Let’s move this code part to the withContext function block.
 We need to provide the context here. As we want to switch to main thread, context should be
 Dispatchers.Main

-There is an another new thing.
 This withContext function is a suspending function.

-We cannot call to a suspend function from a normal function.

-So we have to add suspend modifier to this function declaration like this.

-For now , don’t worry about suspending functions.

-I have dedicated our next lesson entirely for suspending functions.

-So you will be able to learn every thing about Kotlin suspend functions during the next lesson.

-Now , So let’s just very quickly run this and see it in action
 .Yes you can see app is working as we expected.
 So, this is how we switch a coroutine between threads.
 
 
 
##Suspending functions:

-In kotlin coroutines, Whenever a coroutine is suspended,
 the current stack frame of the function is copied and saved in the memory. When the function resumes after
 completing its task, the stack frame is copied back from where it was saved and starts running again.

-Kotlin coroutines API provides us a lot of functions to make our works easier.

-Almost all of them are suspending functions. 
 withContext(), 
 withTimeout(), 
 withTimeoutOrNull(), 
 join(), 
 delay(), 
 await() 
 supervisorScope
 coroutineScope

-There are many suspending functions.

-These are some examples of suspending functions provided by the Kotlin coroutines API.

-Not only coroutines librariy, Other libraries such as room and retrofit also provides suspending funcitons to support us to work
 with coroutines.

-if we are ever going to call those first class suspending functions from our functions
 we have to mark our fucntions with suspend modifier.

-Just like we did in the code example of the previous lesson.

-At the end of the previous lesson , when we were going to use Kotlin
 withContext function , to switch the thread of the coroutine, to display the result on a textview , 
 We marked this download user data function
 with Suspend modifier.

-We had to do it, Actually Android studio forced us to do so, because inside that function we were using
 we were calling, withContext function. Which is a suspending function comes with Kotlinx.Corouintes
 library.

-If we are going to use a suspending function such as withContext, we have to mark our calling function
 with suspend modifier.

-And also if we are going to invoke another suspending function created by us , we have to also mark that
 calling function with suspend modifier. With suspending modifier, we are actually limiting the use of the function
 only for coroutines .

-A suspending function can be called from a coroutine block or from another suspending function only. 
 We cannot invoke a suspending function from a normal function or from other places of the code.

-Actually with suspend modifier we label a function as a function with a heavy long running task. And remember
 a coroutine can invoke both suspending and regular functions , but a suspending function can be invoked by a
 coroutine only. 

-Well, Now , we are going to see what’s happening under the hood. To see what happen under the hood
 we need to see Kotlin bytecodes. To do that Let’s create a simple Kotlin class.

-I am including a non-suspending, normal function here. And now Let’s include a suspending function.

-Let’s rebuld the project to generate bytecodes.

-Now, we should go to Tools > Kotlin > Bytecode >

-This is the Kotlin bytecode of our SuspendDemo class. To make it readable we need to decompile it.
 Click on this DeCompile Button.Ok.

-This is the decompiled java file of our SuspendDemo class. SuspendDemo.decomfiled.java So
 these are the java interpretations of the generated Kotlin bytecodes of two functions we created.

-Let’s have a look again.

-These are the two functions. firstFunction is a normal function.
 secondFunction is a suspendable function.

-You can see our suspending function has been converted by the compiler to another function without
 the suspend keyword, but the compiler has added a new parameter of type Continuation.

-So , What is this Continuation.
 As you can see Continuation is a Kotlin interface which has all the structure required to resume the
 suspended function.

-So this is my brief overview about suspending functions. I think these lessons provide all the basic knowledge
 you need about suspending functions and also provide the background to do your own advanced research
 on suspending functions.

-If you want . So, we use suspending functions to avoid thread blockings and hence to provide smooth, uninterrupted experience

How Suspending Functions Work?
-A suspending function doesn't block a thread,
 but only suspends the coroutine itself. (one thread can have more coroutines)

-The thread is returned to the pool while the coroutine is waiting, and when the waiting is done,
 the coroutine resumes on a free thread in the pool.
 
 
 
##Async and await


-Let’s assume we have to get result from four online data sources and combine them all to show the
 final result to the user.

-First task takes 10 seconds

-Second task takes 15 seconds

-Third task takes 12 seconds. 

-And the fourth task takes 13 seconds.

-We could easily write codes to download these data sets one by one.

-But if we do so, user has to wait at least 50 seconds to see the final result.

-That’s too much waiting. Some users may get angry and uninstall the app. What if we can download all these data in parallel. 

-If we can do so we will be able to show the result in just 15 seconds time.

-Writing codes to download these data in parallel and combine them at the end is called parallel
 decomposition. Parallel decomposition was not that easy.

-We had to write complex, long , difficult to read, difficult to maintain codes for that. But with Kotlin coroutines,
 we can do parallel decomposition very easily.

-Let me show you how to do it.

-For this lesson , I created a new Android studio project .

-I also added coroutines core and courotines android dependencies to the gradle.

-For this lesson , for the demonstration of the theory. let’s just assume we have two remote stores .

-We need get stock count form both of them using different URLs and show the final stock count to the
 user.

-Now I am going to write a function to get the first stock count. private suspend

-We are going to use coroutines to execute these functions . So let’s make them suspendable. Fun.

-Let’s name this function as getStock1 And this should return
 the stock count as an integral value.

-To simulate the delay , that can happened as a result of data processing in the server let’s just use delay
 function. We need to add the time in milliseconds.

-I am delaying the result for 10 seconds. Let’s return some value as the stock count.

-Then, we should add a log to see how this works.

-To the second function we can just copy this one and chage values.

-Name should be get stock2. Let’s delay this for 8 seconds.

-This should be stock 2. Let’s change the stock count also. Now let’s lauch a coroutine in the oncreate function. 
 CoroutineScope for the context, during previous lessons

-We added the thread name with the word Dispatchers. Like here we can add Dispatcher.IO .

-I intentionally did that to teach you about dispatchers. But to save time , if you want , you can just Add
 IO here.

-only the name of the thread

-The difference is, when we add only IO , class has to import kotlinx.coroutines
 .Dispatchers.IO package.

-If we add Dispatcher.IO our class has to import
 kotlinx.coroutines
 dot Dispatchers . All right.

-Now, launch the coroutine.

-Get the value of the stock1.

-Then Get the value of the stock2.
 And then, add them

-For now. Let’s show the total in a log.

-I am adding another log to show the start of the calculation process.

-This is not parallel decomposition.

-We haven’t implemented it yet.

-This is sequential decomposition. What will happen if we run this app ?

-This getStock1 function will execute first. It will wait 10 seconds and return its stock value.

-After that , after 10 seconds execution of getStock2 fucntoin will be started. 
 It will wait another 8 seconds and return its stock value.

-Then finally tatal will be calculated.

-So, let’s just very quickly run that and see it in action .
 And here we go , calculation started.

-count of the Stock1 returned after 10 seconds.

-Count of the stock2 returned after 8 seconds. And final total value loged. You can study the exact
 time gap from here. it took 18 seconds and 33 milliseconds.

-Now, I am going to show you how to do this in parallel way. To do that we need to use async coroutine builder.
 Async and Launch are the coroutine builders we use for Android Development most of the times. 

-Launch coroutine buider returns a job. But async coroutine builder returns
 an instance of Deferred.

-We can use that Deferred value by invoking its await function.

-I am going to make this function calls from within a async coroutine builder. Async

-Let’s take this function call to the inside of the builder. Do the same for the
 getStock2 function call.

-To get the returned value we need to invoke await function of each async builder.

-Now if we run this app these two functions will execute parrallely.

-here, getStock1 function takes 10 seconds. But getStock2 funciton takes only 8 seconds to return the
 count value.

-Therefore if these two functions execute in parallel, getStock2 funciton should return its value
 first.

-Let’s run the app and see the log results.
 Calculation started.

-Count of the Stock2 returned after 8 seconds. Count of the stock1 returned after 10 seconds. And
 final total value loged.

-So instead of 18 seconds this entire process now only takes 10 seconds.

-Thanks to paralle decomposition we implemented using async builder and await function call.
 You can study the exact time form here.

-Time taken for the entire process is 10 seconds and 49 milliseconds
 In this example we launched a co routine in a background thread belong to IO thread pool and did all parallel
 executions there.

-But we have other options also. We can also provide dispatchers for parallel tasks.

-Let me show you with a code example. Now I am changing this to dispatchers.main . 

-Just add main. Android studio will import dispatchers package.

-After that I am going to provide dispatchers.IO context for each of these aysnc blocks.

-Now only these parallel events will happen in the background .

-SInse this code block executes in the main thread we can add a toast message here to show the total value.

-We can cut the message from here.

-Let’s delete the log. Now we can run the app to see the result.

-We need to wait for 10 seconds to see the result.

-Total is 90000.

-So this is how we implement concurrency with coroutines .

-This is how we use async and await to get data from different data sources parallel and combined the result