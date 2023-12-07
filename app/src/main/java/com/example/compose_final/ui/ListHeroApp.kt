package com.example.compose_final.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.navArgument
import com.example.compose_final.navigation.Screen
import com.example.compose_final.ui.AppBar.BottomBar
import com.example.compose_final.ui.AppBar.TopBar
import com.example.compose_final.ui.theme.ComposefinalTheme

@Composable
fun ListHeroApp (
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    Scaffold(
        bottomBar = {
            if (currentRoute != Screen.DetailListHero.route) {
                BottomBar(navController)
            }
        },
        modifier = modifier
    ) { it ->
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = modifier.padding(it)
        ) {
            composable(Screen.Home.route) {
                HomeScreen(navigateToDetail = { data ->
                    navController.navigate(Screen.DetailListHero.createRoute(data)) }
                )
            }
            composable(Screen.Profile.route) {
                ProfileScreen()
            }
            composable(
                route = Screen.DetailListHero.route,
                arguments = listOf(
                    navArgument("charId"){
                        type = NavType.StringType
                    }
                )
            ){
                val id = it.arguments?.getString("charId") ?: ""
                DetailScreen(
                    charId = id,
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ListHeroAppPreview() {
    ComposefinalTheme {
        ListHeroApp()
//        TopBar()
    }
}