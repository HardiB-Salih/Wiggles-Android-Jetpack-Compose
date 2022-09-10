package com.hardib.salih.wiggles.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterStart
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
import androidx.navigation.NavController
import com.hardib.salih.wiggles.R
import com.hardib.salih.wiggles.component.GenderTag
import com.hardib.salih.wiggles.component.detail_component.DogInfoCard
import com.hardib.salih.wiggles.component.detail_component.InfoCard
import com.hardib.salih.wiggles.component.detail_component.OwnerCard
import com.hardib.salih.wiggles.models.Dog
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
            DetailsView(dog)
        }
    )
}

@Composable
fun DetailsView(dog: Dog){
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colors.background)
    ){
        // Basic details
        item {
            dog.apply {
                val dogImage : Painter = painterResource(id = image)
                Image(painter = dogImage,
                    contentDescription = "dog Image",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(346.dp),
                    alignment = Alignment.CenterStart,
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.height(16.dp))
                DogInfoCard(name = name, gender = gender, location = location)

            }
        }

        // My story details
        item {
            dog.apply {
                Spacer(modifier = Modifier.height(24.dp))
                Title(title = "My Story")
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = about,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp, 0.dp, 16.dp, 0.dp),
                    color = MaterialTheme.colors.surface,
                    style = MaterialTheme.typography.body2,
                    textAlign = TextAlign.Start)
            }
        }

        // Quick info
        item {
            dog.apply {
                Spacer(modifier = Modifier.height(24.dp))
                Title(title = "Dog info")
                Spacer(modifier = Modifier.height(16.dp))
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp, 0.dp, 16.dp, 0.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    InfoCard(title = "Age", value = age.toString().plus(" yrs"))
                    InfoCard(title = "Color", value = color)
                    InfoCard(title = "Weight", value = weight.toString().plus("Kg"))
                }
            }
        }

        // Owner info
        item { 
            dog.apply {
                Spacer(modifier = Modifier.height(24.dp))
                Title(title = "Owner info")
                Spacer(modifier = Modifier.height(16.dp))
                owner.apply {
                    OwnerCard(name = name, bio = bio, image = image)
                }
            }
        }

        // CTA - Adopt me button
        item { 
            Spacer(modifier = Modifier.height(36.dp))
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp, 0.dp, 16.dp, 0.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = colorResource(id = R.color.blue),
                    contentColor = Color.White
                )
            ) {
                Text(text = "Adopt me")
            }
            Spacer(modifier = Modifier.height(24.dp))
        }


    }
}


@Composable
fun Title(title: String){
    Text(text = title,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp, 0.dp, 0.dp, 0.dp),
        color = MaterialTheme.colors.surface,
        style = MaterialTheme.typography.subtitle1,
        fontWeight = FontWeight.W600,
        textAlign = TextAlign.Start

    )
}



