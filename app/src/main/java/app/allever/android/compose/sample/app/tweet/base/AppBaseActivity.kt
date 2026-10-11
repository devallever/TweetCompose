package app.allever.android.compose.sample.app.tweet.base

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import app.allever.android.compose.sample.app.tweet.ui.theme.ColorPageBgPrimary
import app.allever.android.compose.sample.app.tweet.ui.theme.TweetComposeTheme
import app.allever.android.lib.core.helper.ActivityHelper
import java.lang.ref.WeakReference

abstract class AppBaseActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ActivityHelper.add(WeakReference(this))
        enableEdgeToEdge()
        setContent {
            TweetComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxSize()
                            .background(color = ColorPageBgPrimary),
                        contentAlignment = androidx.compose.ui.Alignment.Center
                    ) {
                        Content()
                    }
                }
            }
        }

        init()
    }

    abstract fun init()

    @Composable
    abstract fun Content()




    override fun onResume() {
        super.onResume()
        ActivityHelper.onResume(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        ActivityHelper.remove(WeakReference(this))
    }
}