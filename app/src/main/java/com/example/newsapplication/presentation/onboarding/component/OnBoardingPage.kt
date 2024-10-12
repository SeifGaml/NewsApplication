package com.example.newsapplication.presentation.onboarding.component

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.newsapplication.presentation.onboarding.Page
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.newsapplication.R
import com.example.newsapplication.Dimentions
import com.example.newsapplication.Dimentions.MediumPadding2
import com.example.newsapplication.presentation.onboarding.pages
import com.example.newsapplication.ui.theme.NewsApplicationTheme

@Composable
fun OnBoardingPage(
    modifier: Modifier = Modifier,
    page:Page
) {
    Column(modifier = Modifier)
    {

        Image(
            modifier = modifier
                .fillMaxWidth()
                .fillMaxHeight(fraction = 0.6f),
            painter = painterResource(id =page.image),
            contentDescription =null,
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(Dimentions.MediumPadding1))
        Text(text = page.title,
            modifier = Modifier.padding(horizontal = MediumPadding2),
            style = MaterialTheme.typography.displaySmall.copy(fontWeight = FontWeight.Bold),
            color= colorResource(id = R.color.display_small)

        )
        Text(text = page.description,
            modifier = Modifier.padding(horizontal = MediumPadding2),
            style = MaterialTheme.typography.bodyMedium,
            color= colorResource(id = R.color.text_medium)
        )

    }
}
@Preview(showBackground = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun preview(){
    NewsApplicationTheme {
        OnBoardingPage(page = pages[0])

    }

}