package com.aryeetey.performancetesting.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class UserViewModel : ViewModel() {

    private val _userNames = MutableLiveData<List<String>>(arrayListOf())
    val userNames: LiveData<List<String>> = _userNames

    private val _userInput = MutableLiveData("")
    val userInput: LiveData<String> = _userInput

    fun addUserName() {
        val newItem = _userInput.value ?: ""
        val currentList = _userNames.value ?: arrayListOf()
        _userNames.value = currentList + newItem
    }

    fun onTextChanged(input: String) {
        _userInput.value = input
    }
}