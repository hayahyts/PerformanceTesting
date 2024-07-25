package com.aryeetey.performancetesting.ui.screens

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.aryeetey.performancetesting.viewmodels.UserViewModel

@Composable
fun UsersScreen(viewModel: UserViewModel) {
    Surface(
        modifier = Modifier.fillMaxSize(),
    ) {
        UserList(viewModel, { userInput -> viewModel.onTextChanged(userInput) }) {
            viewModel.addUserName()
        }
    }
}

@Composable
fun UserList(
    viewModel: UserViewModel,
    onTextChanged: (String) -> Unit,
    onAddUser: () -> Unit
) {
    val userInput = viewModel.userInput.observeAsState("")
    val userNames = viewModel.userNames.observeAsState(arrayListOf())
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column {
            for (userName in userNames.value) {
                User(name = userName)
            }
        }

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            TextField(value = userInput.value, onValueChange = {
                onTextChanged(it)
            })
            Button(
                modifier = Modifier.wrapContentHeight(), onClick = {
                    onAddUser()
                }) {
                Text(text = "Add User")
            }
        }
    }
}

@Composable
fun User(name: String) {
    Text(
        text = name,
        style = MaterialTheme.typography.titleMedium,
        modifier = Modifier.clickable { Log.d("TAG", "Clicked ooo") }
    )
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewUsersScreen() {
    UsersScreen(viewModel = UserViewModel())
}