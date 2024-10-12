package com.example.newsapplication.presentation.onboarding.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import com.example.newsapplication.Dimentions.IndicatorSize
import com.example.newsapplication.ui.theme.BlueGray


@Composable
fun PageIndicator(
    modifier: Modifier =Modifier,
    pageSize: Int,
    selectedPage :Int,
    selectedColor : Color = MaterialTheme.colorScheme.primary,
    unSelectedColor :Color = BlueGray
){
    Row(modifier = modifier , horizontalArrangement = Arrangement.SpaceBetween ){
        repeat(pageSize) { pages ->
            Box(
                modifier = Modifier
                    .size(IndicatorSize)
                    .clip(CircleShape)
                    .background(color = if (pages == selectedPage) selectedColor else unSelectedColor)
            )

        }

    }

}