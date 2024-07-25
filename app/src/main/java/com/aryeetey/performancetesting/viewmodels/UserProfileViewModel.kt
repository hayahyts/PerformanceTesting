package com.aryeetey.performancetesting.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.aryeetey.performancetesting.model.UserInfo
import kotlin.random.Random

class UserProfileViewModel : ViewModel() {
    private val _userInput = MutableLiveData("John Mahama")
    val userInput: LiveData<String> = _userInput

    private val _users = MutableLiveData(listOf(UserInfo(name = "Laarai", title = "Android Developer", imgUrl = "https://picsum.photos/id/3/5000/3333", isOnline = true)))
    val users: LiveData<List<UserInfo>> = _users

    private val imageUrls = listOf(
        "https://picsum.photos/id/0/5000/3333",
        "https://picsum.photos/id/1/5000/3333",
        "https://picsum.photos/id/2/5000/3333",
        "https://picsum.photos/id/3/5000/3333",
        "https://picsum.photos/id/4/5000/3333",
        "https://picsum.photos/id/5/5000/3334",
        "https://picsum.photos/id/6/5000/3333",
        "https://picsum.photos/id/7/4728/3168",
        "https://picsum.photos/id/8/5000/3333",
        "https://picsum.photos/id/9/5000/3269",
        "https://picsum.photos/id/10/2500/1667"
    )

    fun onTextChanged(input: String) {
        _userInput.value = input
    }

    fun addUserProfile() {
        val newItem = _userInput.value ?: ""
        val randomImageUrl = imageUrls.random()
        val newUser = UserInfo(
            name = newItem,
            title = "Android Developer",
            imgUrl = randomImageUrl,
            isOnline = Random.nextBoolean()
        )
        val currentList = _users.value ?: arrayListOf()
        _users.value = currentList + newUser
        _userInput.value = ""
    }
}