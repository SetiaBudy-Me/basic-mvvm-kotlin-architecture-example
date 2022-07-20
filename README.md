[![kotlin](https://img.shields.io/badge/Kotlin-1.3.xxx-brightgreen.svg)](https://kotlinlang.org/)
[![MVVM](https://img.shields.io/badge/Clean--Code-MVVM-brightgreen.svg)](https://github.com/googlesamples/android-architecture) 
[![Kotlin-Android-Extensions](https://img.shields.io/badge/Kotlin--Android--Extensions-plugin-red.svg)](https://kotlinlang.org/docs/tutorials/android-plugin.html)


# Basic MVVM Kotlin Architecture Example
Contoh aplikasi Android sederhana untuk menunjukkan cara kerja arsitektur MVVM, menggunakan Kotlin, &amp; Lifecycle.

### Screenshots

<div align:left;display:inline;>
  <img width="25%" height="25%" src="https://github.com/SetiaBudy-Me/basic-mvvm-kotlin-architecture-example/blob/master/res/Image%20Screenshot%2001.jpeg"/>
  <img width="25%" height="25%" src="https://github.com/SetiaBudy-Me/basic-mvvm-kotlin-architecture-example/blob/master/res/Image%20Screenshot%2002.jpeg"/>
  <img width="25%" height="25%" src="https://github.com/SetiaBudy-Me/basic-mvvm-kotlin-architecture-example/blob/master/res/Image%20Screenshot%2003.jpeg"/>
</div>

$~~$

## MVVM (Model View ViewModel)
**MVVM** adalah akronim dari Model, View, ViewModel. Secara garis besar MVVM merupakan salah satu architectural patterns yang membagi tanggung jawab kepada tiga komponen utama yaitu Model, View, dan View-Model.

![MVVM](https://upload.wikimedia.org/wikipedia/commons/8/87/MVVMPattern.png)

Masing-masing dari komponen tersebut memiliki tanggung jawab sebagai berikut :

1. ***Model***: Bertanggung jawab untuk menyediakan data yang di butuhkan oleh aplikasi.
   Model / entity adalah representasi dari data yang digunakan pada business logic, dapat berupa Plain Old Java Object (POJO), Kotlin Data Classes.
   Salah satu dari strategi implementasi model adalah membuat model dapat terbuka melalui observables agar terpisah antara ViewModel atau observer/ consumer.

2. ***View***: Bertanggung jawab untuk merepresentasikan data yang berisi User Interface pada aplikasi.
   Representasi dari User Interface (UI) dari sebuah aplikasi, pada Android sendiri view ini dapat berupa Activity atau Fragment.

3. ***View-Model***: Bertanggung jawab untuk menyimpan dan mengambil data dari Model untuk nantinya digunakan dan ditampilkan oleh View, Komponen ini merupakan inti dari Architectural Patterns MVVM. ViewModel berinteraksi dengan model dan juga menyiapkan observables yang akan diobservasi oleh View. ViewModel dapat menyediakan hooks untuk view dan mem-pass events kepada model, salah satu implementasi strategi dari ViewModel adalah untuk memisahkannya dengan View. Contohnya ViewModel tidak seharusnya mengetahui view berinteraksi dengan siapa. ViewModel bertanggung jawab untuk menyiapkan data untuk UI/View/Tampilan. ViewModel merupakan base class yang baik untuk membuat ViewModel karena setiap class yang mengextendnya akan secara otomatis memiliki holding data ketika terjadi perubahan.

$~$

### Kelebihan & Kekurangan MVVM
#### Kelebihan:
- Tidak ada hubungan erat antar view dan view model.
- Tidak ada interface antara viwe dan model.
- Mudah untuk menulis unit testing dan kodenya pun event-driven.

#### Kekurangan:
- Harus membuat observable untuk setiap komponen UI.
- Kode yang ditulis bisa banyak.

$~$

### Praktik Terbaik MVVM:
- Hindari referensi ke Views di ViewModels.
- Alih-alih mendorong data ke UI, biarkan UI mengamati perubahannya.
- Bagikan tanggung jawab, tambahkan lapisan domain jika diperlukan.
- Tambahkan repositori data sebagai entri titik tunggal ke data Anda.
- Mengekspos informasi tentang status data Anda menggunakan pembungkus atau LiveData lainnya.
- Pertimbangkan kasus tepi, kebocoran, dan seberapa lama operasi yang berjalan dapat memengaruhi instans dalam arsitektur Anda.
- Jangan menempatkan logika di ViewModel yang sangat penting untuk menyimpan status bersih atau terkait dengan data. Panggilan apa pun yang Anda lakukan dari ViewModel bisa menjadi yang terakhir.

$~$

## LifecycleObserever
LifecycleObserever adalah salah satu komponen Arsitektur Jetpack dan merupakan antarmuka yang mengamati dan melakukan tugas yang ditentukan tergantung pada perubahan Siklus Hidup pemilik Siklus Hidup. Misalnya, MainActivity memiliki siklus hidupnya sendiri dan dirinya sendiri adalah pemilik Siklus Hidup dan kita dapat mengimplementasikan antarmuka LifecycleObserever dan melampirkan pengamat ini ke MainActivity sehingga operasi tertentu dapat dilakukan saat siklus hidup MainActivity berubah.

$~~$

### Menambahkan Lifecycle ke file gradle Anda
  
>     // Add Lifecycle  
>     implementation 'androidx.lifecycle:lifecycle-extensions:2.2.0'
