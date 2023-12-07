package com.example.compose_final.navigation

sealed class Screen(
    val route: String
) {
    object Home : Screen("home")
    object Profile : Screen("profile")
    object DetailListHero : Screen("home/{charId}") {
        fun createRoute(charId: String) = "home/$charId"
    }
}