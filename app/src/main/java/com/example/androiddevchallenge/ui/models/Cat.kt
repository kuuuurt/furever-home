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