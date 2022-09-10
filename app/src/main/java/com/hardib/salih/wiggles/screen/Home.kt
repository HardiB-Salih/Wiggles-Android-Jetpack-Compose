package com.hardib.salih.wiggles.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.hardib.salih.wiggles.models.Dog
import com.hardib.salih.wiggles.R
import com.hardib.salih.wiggles.component.ItemDogCard
import com.hardib.salih.wiggles.component.TopBar
import com.hardib.salih.wiggles.navigation.WigglesScreen
import com.hardib.salih.wiggles.services.HelperObject
import com.hardib.salih.wiggles.services.SharedViewModel


@Composable
fun Home (navHostController: NavHostController, sharedViewModel: SharedViewModel, dogList: List<Dog>, toggleTheme: () -> Unit) {
        LazyColumn{
            item {
                TopBar (onToggle = {toggleTheme()})
                Spacer(modifier = Modifier.size(8.dp))
            }
            items(dogList){ dog ->
                ItemDogCard(dog = dog,
                    onItemClicked = { dogClicked ->
                        sharedViewModel.addDog(dogClicked)
                        navHostController.navigate(WigglesScreen.DetailScreen.name)
                    })
            }
        }
}












