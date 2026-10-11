package app.allever.android.compose.sample.app.tweet

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.lifecycleScope
import app.allever.android.compose.sample.app.tweet.base.AppBaseActivity
import app.allever.android.compose.sample.app.tweet.module.login.LoginActivity
import app.allever.android.compose.sample.app.tweet.ui.theme.ColorPageBgPrimary
import app.allever.android.compose.sample.app.tweet.ui.theme.TweetComposeTheme
import app.allever.android.lib.core.helper.ActivityHelper
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppBaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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
                        Image(
                            painter = painterResource(R.mipmap.ic_launcher_round),
                            contentDescription = null,
                            modifier = Modifier.size(128.dp),
                            alignment = androidx.compose.ui.Alignment.Center
                        )
                    }
                }
            }
        }

        lifecycleScope.launch {
            delay(1000)
            ActivityHelper.startActivity<LoginActivity>()
            finish()
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!", modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TweetComposeTheme {
        Greeting("Android")
    }
}