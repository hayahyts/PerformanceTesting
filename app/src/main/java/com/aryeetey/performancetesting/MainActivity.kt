package com.aryeetey.performancetesting

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.aryeetey.performancetesting.ui.screens.UserProfilesScreen
import com.aryeetey.performancetesting.ui.screens.UsersScreen
import com.aryeetey.performancetesting.viewmodels.UserProfileViewModel
import com.aryeetey.performancetesting.viewmodels.UserViewModel

class MainActivity : ComponentActivity() {
    private val viewModel: UserProfileViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UserProfilesScreen(viewModel)
        }
    }
}

@Composable
fun GreetingText(name: String) {
    Text(
        text = "Hello $name!",
        style = MaterialTheme.typography.displayMedium
    )
}

@Composable
fun ButtonText(name: String) {
    Button(onClick = { }) {
        Text(name)
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewMainActivity() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        GreetingText("Laarai")
        ButtonText(name = "Laarai")
    }
}
