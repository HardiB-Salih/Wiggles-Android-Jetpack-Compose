package com.hardib.salih.wiggles

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.hardib.salih.wiggles.navigation.WigglesNavigation
import com.hardib.salih.wiggles.services.HelperObject
import com.hardib.salih.wiggles.ui.theme.WigglesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
//            val currentTheme = isSystemInDarkTheme()
//            HelperObject.isDark.value = isSystemInDarkTheme()
            WigglesTheme(darkTheme = HelperObject.isDark.value) {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background,
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                ) {
                    WigglesNavigation(toggleTheme = {HelperObject.onToggleTheme()})
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