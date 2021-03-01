/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Close
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.KEY_ROUTE
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.ui.models.cats
import com.example.androiddevchallenge.ui.screens.CatDetailsScreen
import com.example.androiddevchallenge.ui.screens.CatsScreen
import com.example.androiddevchallenge.ui.theme.FureverHomeTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FureverHomeTheme {
                CatsHome()
            }
        }
    }
}

sealed class Destinations(val route: String) {
    object Cats : Destinations("cats")
    object CatDetails : Destinations("cat-details/{catName}") {
        fun withName(name: String) = this.route.replace("{catName}", name)
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun CatsHome() {
    val navController = rememberNavController()
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    val navBackStackEntry by navController.currentBackStackEntryAsState()
                    val currentRoute = navBackStackEntry?.arguments?.getString(KEY_ROUTE)
                    AnimatedVisibility(currentRoute != null && currentRoute != Destinations.Cats.route) {
                        IconButton(onClick = { navController.popBackStack() }) {
                            Icon(Icons.Rounded.Close, contentDescription = "Back")
                        }
                    }
                    Text(text = "Furever Home 🐱",)
                }
            )
        }
    ) {
        Box(modifier = Modifier.padding(it)) {
            NavHost(navController, startDestination = Destinations.Cats.route) {
                composable(Destinations.Cats.route) {
                    CatsScreen(
                        onCatItemClick = { cat ->
                            navController.navigate(Destinations.CatDetails.withName(cat.name))
                        }
                    )
                }
                composable(Destinations.CatDetails.route) { backStackNavEntry ->
                    val catName = backStackNavEntry.arguments?.getString("catName")
                    val cat = cats.find { cat -> cat.name == catName }!!
                    CatDetailsScreen(cat)
                }
            }
        }
    }
}
