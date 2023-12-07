package com.example.compose_final.ui.AppBar

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Colors
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.primarySurface
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.compose_final.R

@Composable
fun TopBar(navController: NavController) {
    Column {
        TopAppBar(
            elevation = 4.dp,
            title = {
                Text(
                    stringResource(id = R.string.app_name),
                    color = Color.White
                )
            },
            backgroundColor = MaterialTheme.colors.primarySurface,
            navigationIcon = {
                IconButton(onClick = {
                    navController.popBackStack()
                }) {
                    Icon(Icons.Filled.ArrowBack, null)
                }
            }
        )
    }
}

