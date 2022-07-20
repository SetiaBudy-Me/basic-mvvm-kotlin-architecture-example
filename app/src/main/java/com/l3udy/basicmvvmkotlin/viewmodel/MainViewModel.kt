package com.l3udy.basicmvvmkotlin.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.l3udy.basicmvvmkotlin.model.Data

/*
 *  MainViewModel
 *  - ViewModel that updates the MainActivity (the visible UI)
 *  - Gets the data from model
 */
class MainViewModel : ViewModel() {

    // Create MutableLiveData which MainActivity can subscribe to
    // When this data changes, it triggers the UI to do an update
    val resultCount = MutableLiveData<Data>()

    fun count(number1: Int, number2: Int) {
        // Create a new variable called result, to accommodate the result
        val result = number1.times(number2)

        resultCount.value = Data(result)
    }
}