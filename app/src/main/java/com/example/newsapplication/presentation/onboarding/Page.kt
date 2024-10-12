package com.example.newsapplication.presentation.onboarding

import androidx.annotation.DrawableRes
import com.example.newsapplication.R

data class Page(
    val title :String ,
    val description:String,
    @DrawableRes val image :Int
)

val pages = listOf(
    Page(
        title = "Lorem Ispum is simply dummy ",
        description = "Lorem Ipsum is simply dummy text of the printing and typesettings",
        image = R.drawable.onboarding1
    ),
    Page(
        title = "onboarding page two",
        description = " this frist onboarding view screen",
        image = R.drawable.onboarding2
    ),
    Page(
        title = "onboarding page three",
        description = " this frist onboarding view screen",
        image = R.drawable.onboarding3
    ),
)
