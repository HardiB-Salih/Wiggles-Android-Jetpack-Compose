package com.hardib.salih.wiggles.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.hardib.salih.wiggles.R
import com.hardib.salih.wiggles.services.SharedViewModel

@Composable
fun Details(navController: NavController, sharedViewModel: SharedViewModel){

    val dog = sharedViewModel.dog ?: return
    Scaffold (
        topBar = {
            TopAppBar(
                title = { Text(text = "Detail") },
                backgroundColor = MaterialTheme.colors.background,
                contentColor = MaterialTheme.colors.surface,
                navigationIcon = {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Arrow Back",
                        modifier = Modifier
                            .size(24.dp, 24.dp)
                            .clickable { navController.popBackStack() },
                        tint = MaterialTheme.colors.surface
                    )
                }
            )
        },
        content = {
            DetailsView(dog.id)
        }
    )
}

@Composable
fun DetailsView(id: Int){

}