package com.loc.newsapp.presentation.common

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.newsapplication.Dimentions.ArticleCardSize
import com.example.newsapplication.Dimentions.ExtraSmallPadding
import com.example.newsapplication.Dimentions.ExtraSmallPadding2
import com.example.newsapplication.Dimentions.SmallIconSize
import com.example.newsapplication.R
import com.example.newsapplication.ui.theme.NewsApplicationTheme

import com.loc.newsapp.domain.model.Article
import com.loc.newsapp.domain.model.Source


@Composable
fun ArticleCard(
    modifier: Modifier =Modifier,
    article: Article,
    onclick:()-> Unit
){
    val context = LocalContext.current
    Row (
        modifier = modifier.clickable { onclick()} ){
        AsyncImage(
            modifier = Modifier
                .size(ArticleCardSize)
                .clip(MaterialTheme.shapes.medium),
            contentScale = ContentScale.Crop,
            model = ImageRequest.Builder(context).data(article.urlToImage).build(),
            contentDescription = null
        )
        Column(
            verticalArrangement = Arrangement.SpaceAround,
            modifier = Modifier
                .padding(horizontal = ExtraSmallPadding)
                .height(ArticleCardSize)
        )

        {
            Text(text = article.title.toString(), style = MaterialTheme.typography.bodyMedium, color = colorResource(
                id = R.color.text_title
            ),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            Row(verticalAlignment = Alignment.CenterVertically) {
                article.source?.name?.let {
                    Text(text = it,
                        style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold),
                        color = colorResource(id = R.color.body)
                    )
                }
                Spacer(modifier = Modifier.width(ExtraSmallPadding2))
                Icon(painter = painterResource(id = R.drawable.ic_time), contentDescription = null,
                    modifier = Modifier.size(SmallIconSize),
                    tint = colorResource(id = R.color.body)
                )
                Spacer(modifier = Modifier.width(ExtraSmallPadding2))
                Text(text = article.publishedAt.toString() ,
                    style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold),
                    color = colorResource(id = R.color.body)
                )



            }


        }


    }

}
@Preview(showBackground= true)
@Composable
fun ArticleCardPreview(){
    NewsApplicationTheme {
        ArticleCard(article = Article(
            author = "",
            content = "",
            description = "",
            publishedAt = "2 hours",
            source = Source(id = "", name = "BBC"),
            title = "this is a article  ",
            url = "",
            urlToImage = ""
        )) {

        }

    }
}
