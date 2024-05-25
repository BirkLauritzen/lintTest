package com.example.roommateproject.RoomLogin.Components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.roommateproject.RoomLogin.BoxLayout
import com.example.roommateproject.RoomLogin.RoomViewModel
import com.example.roommateproject.ui.theme.Typography
import com.example.roommateproject.ui.theme.jaldiFontFamily
import com.example.roommateproject.ui.theme.lightBlue

@Composable
fun EnterPasswordInput(navigateFrontPage: () -> Unit) {
    val roomViewModel = viewModel<RoomViewModel>()
    BoxLayout(
        value = roomViewModel.password,
        onValueChange = { newValue -> roomViewModel.onPasswordChange(newValue) },
        labelText = "Enter Password",
        height = 0.18f
    )
}