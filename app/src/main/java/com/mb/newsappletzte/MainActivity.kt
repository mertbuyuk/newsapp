package com.mb.newsappletzte

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import com.mb.newsappletzte.presentation.onboarding.onBoardingScreen
import com.mb.newsappletzte.ui.theme.NewsappLetzteTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //splash screen eklendi
        installSplashScreen()
        setContent {
            NewsappLetzteTheme(dynamicColor = false) {
                Box(modifier = Modifier.background(MaterialTheme.colorScheme.background)) {
                    onBoardingScreen()
                }
            }
        }
    }
}