package com.example.newsapplication.presentation.onboarding

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import com.example.newsapplication.Dimentions.MediumPadding1
import com.example.newsapplication.Dimentions.pageIndicatorWidth
import com.example.newsapplication.presentation.common.NewsButton
import com.example.newsapplication.presentation.common.NewsTextButton
import com.example.newsapplication.presentation.onboarding.component.OnBoardingPage
import com.example.newsapplication.presentation.onboarding.component.PageIndicator
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnBoardingScreen(
    event: (OnBoardingEvent)->Unit
){
    Column(modifier = Modifier.fillMaxSize())
    {
        val pagerState  = rememberPagerState(initialPage = 0) {
            pages.size
        }

        val buttonState = remember{
            derivedStateOf {
                when (pagerState.currentPage){
                    0-> listOf("" , "next")
                    1-> listOf("Back" , "Next")
                    2-> listOf("Back", "Get Started")
                    else -> listOf()
                }
            }

        }
        
        HorizontalPager(state = pagerState) { index ->
            OnBoardingPage(page = pages[index])
        }

        Spacer(modifier = Modifier.weight(1f))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = MediumPadding1)
                .navigationBarsPadding(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            PageIndicator( modifier = Modifier.width(pageIndicatorWidth),
                pageSize = pages.size,
                selectedPage =pagerState.currentPage
            )
            Row (verticalAlignment = Alignment.CenterVertically){
                val scope = rememberCoroutineScope()
                if (buttonState.value[0].isNotEmpty()){
                    NewsTextButton(text = buttonState.value[0] ,
                        onclick = {
                            scope.launch {
                                pagerState.animateScrollToPage(page = pagerState.currentPage -1)
                            }
                        }
                    )
                }
                NewsButton(text = buttonState.value[1] ,
                    onclick = {
                        scope.launch {
                            if(pagerState.currentPage == 2){
                                event(OnBoardingEvent.SaveAppEntry)

                            }else{
                                pagerState.animateScrollToPage(
                                    page =  pagerState.currentPage+1
                                )
                            }
                        }
                    }
                )


            }


        }
        Spacer(modifier = Modifier.weight(0.5f))

    }
}