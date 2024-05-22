package com.example.roommateproject.FrontPage.Components.ListView

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.roommateproject.Services.AccountService

@Composable
fun ListScreenStateful(listViewModel: ListViewModel = viewModel()) {
    val lists: List<ShoppingList> = listViewModel.tasks
    val input: State<String?> = listViewModel.inputState

    ListsScreen(
        lists = lists,
        input = input.value,
        onTaskClick = { listViewModel.toggleTaskCompleted(it.id) },
        onInputChange = { listViewModel.onInputChange(it) },
        onRemoveCompleted = { listViewModel.removeCompletedItems() },
        onAddItem = { listViewModel.createTask(it) } // Pass the add item function
    )
}

@Composable
fun ListsScreen(
    lists: List<ShoppingList>,
    input: String?,
    onTaskClick: (ShoppingList) -> Unit,
    onInputChange: (String) -> Unit,
    onSubmitInput: (String) -> Unit,
    onRemoveCompleted: () -> Unit,
    onAddItem: (String) -> Unit // Add this parameter
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 16.dp, top = 16.dp, end = 16.dp, bottom = 16.dp),
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
        ) {
            Box(
                modifier = Modifier
                    .background(skyBlue)
                    .padding(12.dp) // Add some padding around the text for better appearance
            ) {
                Text(
                    text = "WE NEED",
                    fontFamily = jaldiFontFamily,
                    style = Typography.titleSmall,
                    color = darkGreen,
                )
            }
        }
            HorizontalDivider(
                modifier = Modifier
                    .fillMaxWidth(0.99f)
                    .padding(top = 15.dp), // Adjust padding to move the line below the text
                thickness = 2.dp,
                color = Shadow10
            )

            Row {
                BasicTextField(
                    value = input ?: "",
                    onValueChange = {
                        onInputChange(it)
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp)
                )
            }
            lists.forEach { task ->
                Text(
                    text = if (task.completed) "✓ ${task.title}" else task.title,
                    modifier = Modifier
                        .clickable { onTaskClick(task) }
                        .padding(vertical = 8.dp)
                )
            }
            Spacer(modifier = Modifier.height(16.dp))

            Row {
                ListAddButton(onAddItem = onAddItem) // Add the AddToListButton here

                Spacer(modifier = Modifier.width(16.dp))

                OutlinedButton(
                    modifier = Modifier,
                    border = BorderStroke(2.dp, White),
                    colors = ButtonDefaults.buttonColors(
                        Color.Transparent // Set the button background to lightYellow,
                    ),
                    onClick = onRemoveCompleted
                ) {
                    Text(
                        "Remove Completed",
                        fontFamily = jaldiBoldFontFamily,
                        style = Typography.bodyLarge,
                        color = white
                    )
                }
            }
        }
    }

@Preview(showBackground = true)
@Composable
fun PreviewTasksScreen() {
    ListsScreen(
        lists = ListViewModel.sampleTasks,
        input = null,
        onTaskClick = {},
        onInputChange = {},
        onSubmitInput = {},
        onRemoveCompleted = {},
        onAddItem = {} // Add this parameter
    )
}