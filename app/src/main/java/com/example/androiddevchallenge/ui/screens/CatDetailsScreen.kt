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
package com.example.androiddevchallenge.ui.screens

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.models.Cat
import com.example.androiddevchallenge.ui.models.Gender
import dev.chrisbanes.accompanist.coil.CoilImage

@Composable
fun CatDetailsScreen(cat: Cat) {
    Column(
        modifier = Modifier.fillMaxWidth().animateContentSize()
    ) {
        CoilImage(
            data = cat.image,
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier.animateContentSize(),
            fadeIn = true,
            loading = {
                CircularProgressIndicator(Modifier.align(Alignment.Center))
            }
        )
        Row(modifier = Modifier.fillMaxWidth()) {
            Column(
                modifier = Modifier.padding(16.dp),
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = cat.name,
                        style = MaterialTheme.typography.h5
                    )
                    Card(
                        backgroundColor = Color(
                            when (cat.gender) {
                                Gender.MALE -> 0xFFAEC6CF
                                Gender.FEMALE -> 0xFFFFD1DC
                            }
                        )
                    ) {
                        Text(
                            text = when (cat.gender) {
                                Gender.MALE -> "♂"
                                Gender.FEMALE -> "♀"
                            },
                            style = MaterialTheme.typography.h6,
                            modifier = Modifier.padding(horizontal = 8.dp)
                        )
                    }
                }
                Text(
                    text = cat.breed,
                    style = MaterialTheme.typography.body1
                )
                Text(
                    text = "${cat.weight} kg",
                    style = MaterialTheme.typography.body1
                )
            }
        }
    }
    Column(
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        FloatingActionButton(
            onClick = { }
        ) {
            Text(
                text = "Adopt me right meow! 🐱",
                style = MaterialTheme.typography.button,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }
    }
}
