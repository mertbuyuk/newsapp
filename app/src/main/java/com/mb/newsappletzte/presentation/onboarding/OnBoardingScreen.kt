package com.mb.newsappletzte.presentation.onboarding

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mb.newsappletzte.presentation.Dimens.MediumPadding2
import com.mb.newsappletzte.presentation.common.NewsButton
import com.mb.newsappletzte.presentation.common.NewsTextButton
import com.mb.newsappletzte.presentation.onboarding.components.OnBoardingPage
import com.mb.newsappletzte.presentation.onboarding.components.PagerIndicator
import com.mb.newsappletzte.ui.theme.NewsappLetzteTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun onBoardingScreen(){

    Column(modifier = Modifier.fillMaxSize()) {
        //stateler eklendi

        //derived state ile hesaplanip tekrar atanacak degerleri yönetebilirsin
        val pagerState = rememberPagerState(initialPage = 0)

        val buttonState = remember {
            derivedStateOf {
                when(pagerState.currentPage){
                    0 -> listOf("", "Next")
                    1 -> listOf("Back", "Next")
                    2 -> listOf("Back", "Get Started")
                    else -> listOf("", "")
                }
            }
        }

        HorizontalPager(pageCount = pages.size, state = pagerState) { index ->
            OnBoardingPage(modifier = Modifier.fillMaxHeight(0.9f), page = pages[index])
        }
        //Spacer(modifier = Modifier.weight(1f))
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = MediumPadding2)
            .navigationBarsPadding()
            ,horizontalArrangement = Arrangement.SpaceBetween
            ,verticalAlignment = Alignment.CenterVertically) {

            PagerIndicator(modifier = Modifier.width(52.dp)
                ,pagesSize = pages.size
                ,selectedPage =pagerState.currentPage )

            Row(verticalAlignment = Alignment.CenterVertically) {
                val scope = rememberCoroutineScope()

                if (buttonState.value[0].isNotEmpty()){
                    NewsTextButton(
                        text = buttonState.value[0],
                        onClick = {
                            scope.launch {
                                pagerState.animateScrollToPage(
                                    page = pagerState.currentPage - 1
                                )
                            }

                        }
                    )
                }
                NewsButton(
                    text = buttonState.value[1],
                    onClick = {
                        scope.launch {
                            if (pagerState.currentPage == 3){
                                //Navigate to the main screen and save a value in datastore preferences
                            }else{
                                pagerState.animateScrollToPage(
                                    page = pagerState.currentPage + 1
                                )
                            }
                        }
                    }
                )
                //Spacer(modifier = Modifier.weight(0.5f))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun previewOnBoardingScreen(){
    NewsappLetzteTheme {
        onBoardingScreen()
    }
}