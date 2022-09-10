package com.hardib.salih.wiggles.navigation

enum class WigglesScreen {
    HomeScreen,
    DetailScreen;
    companion object {
        fun fromRoute(route: String?): WigglesScreen =
            when (route?.substringBefore("/")) {
                HomeScreen.name -> HomeScreen
                DetailScreen.name -> DetailScreen
                null -> HomeScreen
                else -> throw IllegalArgumentException("Route $route is not recognize")
            }
    }
}