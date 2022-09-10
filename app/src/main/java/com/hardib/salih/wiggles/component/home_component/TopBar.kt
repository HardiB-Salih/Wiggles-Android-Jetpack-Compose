package com.hardib.salih.wiggles.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.hardib.salih.wiggles.R
import com.hardib.salih.wiggles.services.HelperObject
import com.hardib.salih.wiggles.services.SharedPrefDataStore
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking

@Composable
fun TopBar(onToggle: () -> Unit) {
    Row(modifier = Modifier.fillMaxWidth())  {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "Hey Spikey,",
                textAlign = TextAlign.Start,
                style = MaterialTheme.typography.h5,
                color = MaterialTheme.colors.surface
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Adopt a new friend near you!",
                textAlign = TextAlign.Start,
                style = MaterialTheme.typography.subtitle1,
                color = MaterialTheme.colors.surface
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 24.dp, 36.dp, 0.dp),
            horizontalArrangement = Arrangement.End
        ) {
            WigglesThemeSwitch (onToggle = {onToggle()})
        }
    }
}

@Composable
fun WigglesThemeSwitch(onToggle: () -> Unit) {
    val dataStore = SharedPrefDataStore(LocalContext.current)
    val initialBool = runBlocking { dataStore.getIsDark.first() }
    val isDark = dataStore.getIsDark.collectAsState(initial = initialBool)
    val icon = if (isDark.value)
        painterResource(id = R.drawable.ic_light_off)
    else
        painterResource(id = R.drawable.ic_light_on)

    Icon(painter = icon,
        contentDescription = "Icon",
        modifier = Modifier
            .size(24.dp, 24.dp)
            .clickable(onClick = onToggle),
        tint = MaterialTheme.colors.surface
    )
}