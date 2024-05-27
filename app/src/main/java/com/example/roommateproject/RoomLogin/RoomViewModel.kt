package com.example.roommateproject.RoomLogin

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.roommateproject.Services.AccountService
import kotlinx.coroutines.launch

class RoomViewModel: ViewModel() {
    private val accountService: AccountService = AccountService();

    var houseName by mutableStateOf("")
        private set;
    var password by mutableStateOf("")
        private set;

    var members by mutableStateOf<List<String>>(emptyList())
        private set

    fun onHouseNameChange(name: String) {
        this.houseName = name;
    }

    fun onPasswordChange(password: String) {
        this.password = password;
    }

    fun onMembersChange(members: List<String>) {
        this.members = members;
    }


    fun registerNewHouse(navigateFrontPage: () -> Unit) {
        viewModelScope.launch {
        accountService.createNewHouse(houseName, password, members) { success, errorMessage ->
            if (success as Boolean) {
                println("House registered successfully!")
                navigateFrontPage() // Navigates user to the RoomLogin screen
            } else {
                println("House registration failed: $errorMessage") // Registration failed
            }
        }
            accountService.getEvents()
        }
    }

    fun houseLogin(navigateFrontPage: () -> Unit) {
        viewModelScope.launch {
        accountService.homeLogin(houseName, password, members) { success, errorMessage ->
            if (success as Boolean) {
                println("House Login Successful!")
                navigateFrontPage() // Navigates user to the RoomLogin screen
            } else {
                println("House login failed: $errorMessage") // Registration failed
            }
        }
            accountService.getEvents()
        }
    }
}

@Preview
@Composable
fun HousePreview () {
    RoomLogin(navigateFrontPage = {})
}