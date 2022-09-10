package com.hardib.salih.wiggles.services

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.mutableStateOf

object HelperObject {
    val isDark = mutableStateOf(false)
    fun onToggleTheme(){
        isDark.value = !isDark.value
    }
}