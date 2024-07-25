package com.aryeetey.performancetesting.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aryeetey.performancetesting.model.UserInfo
import com.aryeetey.performancetesting.ui.components.CircularImage
import com.aryeetey.performancetesting.viewmodels.UserProfileViewModel

@Composable
fun UserProfilesScreen(viewModel: UserProfileViewModel) {
    Surface(
        color = Color.DarkGray,
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 16.dp, end = 16.dp, bottom = 16.dp)
    ) {
        ProfileList(viewModel, { userInput -> viewModel.onTextChanged(userInput) }) {
            viewModel.addUserProfile()
        }
    }
}

@Composable
fun ProfileList(
    viewModel: UserProfileViewModel,
    onTextChanged: (String) -> Unit,
    onAddUser: () -> Unit
) {
    val userInput = viewModel.userInput.observeAsState("")
    val users = viewModel.users.observeAsState(arrayListOf())
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column {
            for (userInfo in users.value) {
                Spacer(modifier = Modifier.size(16.dp))
                ProfileCard(userInfo = userInfo)
            }
        }

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            TextField(
                value = userInput.value,
                modifier = Modifier.fillMaxWidth(.7f),
                onValueChange = {
                    onTextChanged(it)
                })
            Spacer(modifier = Modifier.size(16.dp))
            Button(
                modifier = Modifier.wrapContentWidth(),
                onClick = {
                    onAddUser()
                }) {
                Text(text = "Add", maxLines = 1, softWrap = false)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileCard(userInfo: UserInfo) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        onClick = { /*TODO*/ },
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            ProfileImage(userInfo)
            ProfileContent(userInfo)
        }
    }
}

@Composable
private fun ProfileContent(userInfo: UserInfo) {
    Column {
        Text(text = userInfo.name, style = MaterialTheme.typography.headlineSmall)
        Text(text = userInfo.title, style = MaterialTheme.typography.bodyLarge)
    }
}

@Composable
private fun ProfileImage(userInfo: UserInfo) {
    Card(
        shape = CircleShape,
        modifier = Modifier
            .padding(16.dp)
            .size(60.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        border = BorderStroke(2.dp, if (userInfo.isOnline) Color.Green else Color.Red)
    ) {
        CircularImage(url = userInfo.imgUrl, modifier = Modifier.size(60.dp))
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewUserProfilesScreen() {
    Surface(modifier = Modifier.padding(16.dp)) {
        ProfileCard(userInfo = UserInfo(name = "Laarai", title = "Divaloper", imgUrl = "imgUrl", isOnline = true))
    }
}