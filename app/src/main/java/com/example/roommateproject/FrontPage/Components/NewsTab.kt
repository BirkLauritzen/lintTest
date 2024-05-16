package com.example.roommateproject.FrontPage.Components

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.roommateproject.R
import com.example.roommateproject.Services.AccountService
import com.example.roommateproject.ui.theme.boxLayerGrey
import com.example.roommateproject.ui.theme.earthyBrown
import com.example.roommateproject.ui.theme.jaldiFontFamily
import java.time.format.DateTimeFormatter

@Composable
fun NewsTab() {
    val accountService: AccountService = AccountService();


    Box(
        modifier = Modifier
            .clip(shape = RoundedCornerShape(30.dp)),
        contentAlignment = Alignment.TopCenter,
    ) {
        Box(
            modifier = Modifier
                .background(boxLayerGrey)
                .fillMaxHeight(0.25f)
                .fillMaxWidth(0.85f)
                .clip(shape = RoundedCornerShape(52.dp)),
            contentAlignment = Alignment.Center,
        ) {
            Box(
                modifier = Modifier
                    .background(Color.White)
                    .fillMaxHeight(0.9f)
                    .verticalScroll(ScrollState(1), true)
                    .fillMaxWidth(0.95f),
                contentAlignment = Alignment.TopCenter
            ) {
                Column(modifier = Modifier,
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Row(
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally),
                    ) {
                        Text(
                            text = "News",
                            color = earthyBrown,
                            fontFamily = jaldiFontFamily,
                            fontSize = 25.sp
                        )
                    }

                    val eventString = AccountService.currentEvents.joinToString("\n\n") { " ${it.eventType.eventText}      ${it.timeStamp}" }
                    Text(text = eventString,
                        fontFamily = jaldiFontFamily,
                        color = Color.DarkGray,
                        fontSize = 16.sp
                        )
                }
            }
        }
    }
}
