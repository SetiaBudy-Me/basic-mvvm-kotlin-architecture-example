[![kotlin](https://img.shields.io/badge/Kotlin-1.3.xxx-brightgreen.svg)](https://kotlinlang.org/)
[![MVVM](https://img.shields.io/badge/Clean--Code-MVVM-brightgreen.svg)](https://github.com/googlesamples/android-architecture) 
[![coroutines](https://img.shields.io/badge/coroutines-asynchronous-red.svg)](https://kotlinlang.org/docs/reference/coroutines-overview.html)
[![Kotlin-Android-Extensions](https://img.shields.io/badge/Kotlin--Android--Extensions-plugin-red.svg)](https://kotlinlang.org/docs/tutorials/android-plugin.html)


# Basic MVVM Kotlin Architecture Example
Contoh aplikasi Android sederhana untuk menunjukkan cara kerja arsitektur MVVM, menggunakan Kotlin, &amp; Lifecycle.

### Screenshots

<div align:left;display:inline;>
  <img width="200" height="360" src="https://github.com/SetiaBudy-Me/basic-mvvm-kotlin-architecture-example/blob/master/screenshot/Image%2001.jpeg"/>
  <img width="200" height="360" src="https://github.com/SetiaBudy-Me/basic-mvvm-kotlin-architecture-example/blob/master/screenshot/Image%2002.jpeg"/>
</div>

$~~$

### Apa itu Coroutines?
Coroutine adalah pola desain serentak yang dapat Anda gunakan di Android untuk menyederhanakan kode yang dieksekusi secara asinkron.
  
### Bagaimana konsep Coroutine bekerja?
 - Kotlin coroutine is a way of doing things asynchronously in a sequential manner. Creating a coroutine is a lot cheaper vs creating a thread.  
  
  
**When I can choose Coroutines or RX-Kotlin to do some behaviour ?**  
--------------------------  
 - Coroutines : *When we have concurrent tasks , like you would fetch data from Remote connections  
 , database , any background processes , sure you can use RX in such cases too, but it looks like  
  you use a tank to kill ant.*  
 - RX-Kotlin : *When you would to handle stream of UI actions like : user scrolling , clicks ,  
 update UI upon some events .....ect .*  
  
  
**What is the Coroutines benefits?**  
-----------------------------  
  
 - Writing an asynchronous code is sequential manner.  
 - Costing of create coroutines are much cheaper to crate threads.  
 - Don't be over engineered to use observable pattern, when no need to use it.  
 - parent coroutine can automatically manage the life cycle of its child coroutines for you.  
  
  
**Handle Retrofit with Coroutines**  
-----------------------------  
![8399](https://user-images.githubusercontent.com/1812129/68318999-e93b0680-00bd-11ea-9d76-058222c7a654.png)
  
 - Add Coroutines to your gradle file  
  
>     // Add Coroutines  
>     implementation 'org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.2'  
>     implementation 'org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.2'  
>     implementation 'org.jetbrains.kotlinx:kotlinx-coroutines-core-common:1.3.2'  
>     // Add Retrofit2  
>     implementation 'com.squareup.retrofit2:retrofit:2.6.2'  
>     implementation 'com.squareup.retrofit2:converter-gson:2.6.2'  
>     implementation 'com.squareup.okhttp3:okhttp:4.2.2'  
  
  
- Make Retrofit Calls.  
  
>     @GET("topstories/v2/home.json")  
>     fun fetchNews(): Call<NewsModel>  
  
  
 - With ```async``` we create new coroutine and returns its future result as an implementation of [Deferred].  
 - The coroutine builder called ```launch``` allow us to start a coroutine in background and keep working in the meantime.  
 - so async will run in background then return its promised result to parent coroutine which  
 created by launch.  
 - when we get a result, it is up to us to do handle the result.  
