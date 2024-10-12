package com.example.newsapplication.presentation.common

import android.annotation.SuppressLint
import android.content.res.Configuration
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.newsapplication.Dimentions.ArticleCardSize
import com.example.newsapplication.Dimentions.ExtraSmallPadding
import com.example.newsapplication.Dimentions.MediumPadding2
import com.example.newsapplication.R
import com.example.newsapplication.ui.theme.NewsApplicationTheme
import com.loc.newsapp.domain.model.Article
import com.loc.newsapp.presentation.common.ArticleCard
import com.loc.newsapp.presentation.common.ArticleCardPreview

@SuppressLint("ModifierFactoryUnreferencedReceiver")
fun Modifier.ShimmerEffect() = composed {

    val trasition = rememberInfiniteTransition()
    val alpha = trasition.animateFloat(
        initialValue = .2f, targetValue = .9f, animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 1000),
            repeatMode = RepeatMode.Reverse
        )
    ).value
    background(color = colorResource(id = R.color.shimmer).copy(alpha = alpha))
}
@Composable
fun ArticleCardShimmerEffect(
    modifier: Modifier =Modifier
) {
    Row(modifier = Modifier) {
        Box(
            modifier = Modifier
                .size(ArticleCardSize)
                .clip(MaterialTheme.shapes.medium)
                .ShimmerEffect()
        )
            Column(
                verticalArrangement = Arrangement.SpaceAround,
                modifier = Modifier
                    .padding(horizontal = ExtraSmallPadding)
                    .height(ArticleCardSize)
            )
            {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(30.dp)
                        .padding(horizontal = MediumPadding2)
                        .ShimmerEffect()
                )

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth(0.5f)
                            .height(15.dp)
                            .padding(horizontal = MediumPadding2)
                            .ShimmerEffect()
                    )
                }


            }

    }
}


@Preview(showBackground = true)
@Preview(showBackground = true , uiMode = Configuration.UI_MODE_NIGHT_YES)

@Composable
fun ArticleCardShimmerEffectPreview(){
    NewsApplicationTheme {
     // ArticleCardPreview()
        ArticleCardShimmerEffect()

    }
}
