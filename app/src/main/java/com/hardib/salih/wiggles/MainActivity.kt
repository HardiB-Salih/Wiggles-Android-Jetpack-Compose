package com.hardib.salih.wiggles

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animate
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.hardib.salih.wiggles.navigation.WigglesNavigation
import com.hardib.salih.wiggles.services.HelperObject
import com.hardib.salih.wiggles.services.SharedPrefDataStore
import com.hardib.salih.wiggles.ui.theme.WigglesTheme
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val context = LocalContext.current
            val scope = rememberCoroutineScope()
            val dataStore = SharedPrefDataStore(context)
            val initialBool = runBlocking { dataStore.getIsDark.first() }
            val isDark = dataStore.getIsDark.collectAsState(initial = initialBool)

//            val currentTheme = isSystemInDarkTheme()
//            HelperObject.isDark.value = isSystemInDarkTheme()
            WigglesTheme(darkTheme = isDark.value) {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background,
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                ) {
                    WigglesNavigation(toggleTheme = {
                        scope.launch {
                            dataStore.saveTheme(!isDark.value)
                        }
                    })
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!", style = MaterialTheme.typography.h5)
}




@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    WigglesTheme {
        Greeting("Android")
    }
}