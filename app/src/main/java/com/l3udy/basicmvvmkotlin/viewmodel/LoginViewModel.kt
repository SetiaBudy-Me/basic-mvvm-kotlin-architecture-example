package com.l3udy.basicmvvmkotlin.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.l3udy.basicmvvmkotlin.R
import com.l3udy.basicmvvmkotlin.model.ApiResult

/*
 *  LoginViewModel
 *  - ViewModel that updates the LoginActivity (the visible UI)
 *  - Gets the data from model
 */
class LoginViewModel : ViewModel() {

    // Create MutableLiveData which LoginActivity can subscribe to
    // When this data changes, it triggers the UI to do an update
    val loginResult = MutableLiveData<ApiResult>()

    fun login(email: String, password: String) {
        if (email.isEmpty() || password.isEmpty()) {
            loginResult.value = ApiResult(error = R.string.login_email_password_empty)
        } else {
            loginResult.value = ApiResult(success = true)
        }
    }
}