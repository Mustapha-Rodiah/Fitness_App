package com.example.fitnessapp.components

import com.example.fitnessapp.R

data class RowData (val images: Int, val text: Int)
val rowDataList = listOf(

   RowData(images = R.drawable.ab1_inversions, text = R.string.ab1_inversions),
    RowData(images = R.drawable.ab2_quick_yoga, text = R.string.ab2_quick_yoga),
    RowData(images = R.drawable.ab3_stretching, text = R.string.ab3_stretching),
    RowData(images = R.drawable.ab4_tabata, text = R.string.ab4_tabata),
    RowData(images = R.drawable.ab5_hiit, text = R.string.ab5_hiit),
    RowData(images = R.drawable.ab6_pre_natal_yoga, text = R.string.ab6_pre_natal_yoga),


)