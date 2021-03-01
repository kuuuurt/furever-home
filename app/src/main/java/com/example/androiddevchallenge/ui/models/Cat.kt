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
package com.example.androiddevchallenge.ui.models

data class Cat(
    val name: String,
    val image: String,
    val gender: Gender,
    val breed: String,
    val weight: Float
)

enum class Gender {
    MALE,
    FEMALE
}

val cats = listOf(
    Cat(
        "Patch",
        "https://cdn2.thecatapi.com/images/vCGSc-o44.png",
        Gender.FEMALE,
        "Manx",
        3.6f
    ),
    Cat(
        "Puffins",
        "https://cdn2.thecatapi.com/images/JdMcWHjhB.jpg",
        Gender.FEMALE,
        "Singapura",
        2.5f
    ),
    Cat(
        "Tiger",
        "https://cdn2.thecatapi.com/images/9csbcNusK.jpg",
        Gender.MALE,
        "Himalayan",
        4f
    ),
    Cat(
        "Stripes",
        "https://cdn2.thecatapi.com/images/_bEDJbZTv.png",
        Gender.MALE,
        "American Curl",
        4.3f
    ),
    Cat(
        "Figaro",
        "https://cdn2.thecatapi.com/images/d9d.jpg",
        Gender.MALE,
        "Ocicat",
        3.2f
    )
)
