package com.example.roommateproject.FrontPage.Components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.roommateproject.R

@Composable
fun NewsTab() {
    Box(
        modifier = Modifier
            .fillMaxHeight(0.2f)
            .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.news),
            contentDescription = null, // Provide proper content description
            modifier = Modifier
                .height(180.dp) // Adjust the height of the Image
        )
    }
}