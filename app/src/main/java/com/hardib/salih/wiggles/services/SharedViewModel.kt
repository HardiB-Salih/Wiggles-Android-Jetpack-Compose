package com.hardib.salih.wiggles.services

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.hardib.salih.wiggles.models.Dog

class SharedViewModel : ViewModel(){

     var dog by mutableStateOf<Dog?>(null)
        private set

    fun addDog(newDog: Dog){
        dog = newDog
    }
}