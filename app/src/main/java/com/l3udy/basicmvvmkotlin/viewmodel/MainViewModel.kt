package com.l3udy.basicmvvmkotlin.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.l3udy.basicmvvmkotlin.model.DataModel

/*
 *  MainViewModel
 *  - viewModel that updates the MainActivity (the visible UI)
 *  - gets the data from model
 */
class MainViewModel : ViewModel() {

    // Create the model which contains data for our UI
    private val model = DataModel(textForUI = "Here's the updated text!")

    // Create MutableLiveData which MainActivity can subscribe to
    // When this data changes, it triggers the UI to do an update
    val uiTextLiveData = MutableLiveData<String>()

    // Get the updated text from our model and post the value to MainFragment
    fun getUpdatedText() {
        val updatedText = model.textForUI
        uiTextLiveData.postValue(updatedText)
    }
}