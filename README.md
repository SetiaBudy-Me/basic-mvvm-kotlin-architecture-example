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

### LifecycleObserever
LifecycleObserever adalah salah satu komponen Arsitektur Jetpack dan merupakan antarmuka yang mengamati dan melakukan tugas yang ditentukan tergantung pada perubahan Siklus Hidup pemilik Siklus Hidup. Misalnya, MainActivity memiliki siklus hidupnya sendiri dan dirinya sendiri adalah pemilik Siklus Hidup dan kita dapat mengimplementasikan antarmuka LifecycleObserever dan melampirkan pengamat ini ke MainActivity sehingga operasi tertentu dapat dilakukan saat siklus hidup MainActivity berubah.

$~~$

### Menambahkan Lifecycle ke file gradle Anda
  
>     // Add Lifecycle  
>     implementation 'androidx.lifecycle:lifecycle-extensions:2.2.0'
