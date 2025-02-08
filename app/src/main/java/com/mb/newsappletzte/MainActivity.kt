package com.mb.newsappletzte

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.lifecycleScope
import com.mb.newsappletzte.domain.usecases.AppEntryUseCases
import com.mb.newsappletzte.presentation.navgraph.NavGraph
import com.mb.newsappletzte.presentation.onboarding.OnBoardingScreen
import com.mb.newsappletzte.presentation.onboarding.OnBoardingViewModel
import com.mb.newsappletzte.ui.theme.NewsappLetzteTheme
import dagger.hilt.EntryPoint
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var appEntryUseCases: AppEntryUseCases

    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //splash screen eklendi
        //setKeepOnScreenCondition kosul gerceklesene kadar splash
        //screeni ekranda tutar
        installSplashScreen().apply {
            setKeepOnScreenCondition {
                viewModel.splashCondition.value
            }
        }
        setContent {
            NewsappLetzteTheme(dynamicColor = false) {
                Box(modifier = Modifier.background(MaterialTheme.colorScheme.background)) {
                    NavGraph(startDestination = viewModel.startDestination.value)
                }
            }
        }
    }
}