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
