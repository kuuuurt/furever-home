package com.example.androiddevchallenge.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.models.Cat
import com.example.androiddevchallenge.ui.models.Gender
import com.example.androiddevchallenge.ui.models.cats
import dev.chrisbanes.accompanist.coil.CoilImage

@Composable
fun CatsScreen(onCatItemClick: (Cat) -> Unit) {
    val fakeCats = mutableListOf<Cat>().apply {
        addAll(cats)
        addAll(cats)
        addAll(cats)
        addAll(cats)
    }
    CatsList(fakeCats, onCatItemClick)
}

@Composable
fun CatsList(cats: List<Cat>, onCatItemClick: (Cat) -> Unit) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(8.dp)
    ) {
        items(cats) {
            CatItem(cat = it, onCatItemClick = onCatItemClick)
        }
    }
}

@Composable
fun CatItem(cat: Cat, onCatItemClick: (Cat) -> Unit) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .clickable { onCatItemClick(cat) }
        ,
        elevation = 8.dp
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {
            CoilImage(
                data = cat.image,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.requiredSize(120.dp),
                fadeIn = true
            )
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
}


