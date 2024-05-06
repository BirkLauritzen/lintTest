package com.example.roommateproject.FrontPage

import HomeButton
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.roommateproject.FrontPage.Components.AddToListButton
import com.example.roommateproject.FrontPage.Components.ChatButton
import com.example.roommateproject.FrontPage.Components.DropDownCalendar
import com.example.roommateproject.FrontPage.Components.EarlyMorningButton
import com.example.roommateproject.FrontPage.Components.GuestVisitButton
import com.example.roommateproject.SharedComponents.Header
import com.example.roommateproject.FrontPage.Components.LogoutButton
import com.example.roommateproject.FrontPage.Components.NewsTab
import com.example.roommateproject.FrontPage.Components.SleepingButton
import com.example.roommateproject.FrontPage.Components.WorkingLateButton
import com.example.roommateproject.ui.theme.white

@Composable
fun FrontPage(navigateRegisterPage: () -> Unit, function: () -> Unit) {
    val frontPageViewModel = viewModel<FrontPageViewModel>()

    Column (
        modifier = Modifier
            .background(white)
    ){
        Header() // Calls the Header file from Components
        Row {
            HomeButton() // Calls the HomeButton file from Components
            AddToListButton() // Calls the AddToListButton file from Components
            ChatButton() // Calls the ChatButton file from Components
        }

        Row {
            NewsTab() // Calls the NewsTab file from Components
        }
        Spacer(modifier = Modifier.height(16.dp))

        Row {
            DropDownCalendar() // Calls the CalendarTab file from Components
        }
        Row {
            SleepingButton() // Calls the SleepingButton file from Components
            WorkingLateButton() // Calls the WorkingLateButton file from Components
        }
        Row {
            GuestVisitButton() // Calls the GuestVisitButton file from Components
            EarlyMorningButton() // Calls the EarlyMorning file from Components
        }
        Spacer(modifier = Modifier.height(16.dp))

        Row {
            LogoutButton(navigateRegisterPage = navigateRegisterPage) {
            }  // Calls the LogoutButton file from Components and navigates the user when clicked
        }
    }
}
