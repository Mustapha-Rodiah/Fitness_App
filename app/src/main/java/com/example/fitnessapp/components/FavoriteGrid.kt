package com.example.fitnessapp.components

import com.example.fitnessapp.R

data class FavoriteCollectionGrid (val images: Int, val text: Int)
val gridList = listOf(
    FavoriteCollectionGrid(images = R.drawable.fc1_short_mantras, text = R.string.fc1_short_mantras),
    FavoriteCollectionGrid(images = R.drawable.fc3_stress_and_anxiety, text = R.string.fc3_stress_and_anxiety),
    FavoriteCollectionGrid(images = R.drawable.fc5_overwhelmed, text = R.string.fc5_overwhelmed),
    FavoriteCollectionGrid(images = R.drawable.fc2_nature_meditations, text = R.string.fc2_nature_meditations),
    FavoriteCollectionGrid(images = R.drawable.fc4_self_massage, text = R.string.fc4_self_massage),
    FavoriteCollectionGrid(images = R.drawable.fc6_nightly_wind_down, text = R.string.fc6_nightly_wind_down)

)