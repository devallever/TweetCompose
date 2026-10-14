package app.allever.android.compose.sample.app.tweet.module.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import app.allever.android.compose.sample.app.tweet.R
import app.allever.android.compose.sample.app.tweet.base.AppBaseActivity
import app.allever.android.compose.sample.app.tweet.ui.theme.ColorTextPrimary
import app.allever.android.compose.sample.app.tweet.ui.theme.ColorTextPrimaryReverse
import app.allever.android.lib.core.ext.toast
import kotlinx.coroutines.launch

class MainActivity : AppBaseActivity() {
    override fun init() {

    }


    @Preview(showBackground = false)
    @Composable
    override fun Content() {
        val pageState = rememberPagerState { 4 }
        val tabState = remember { mutableIntStateOf(0) }
        val scope = rememberCoroutineScope()

        // 监听 HorizontalPager 页面滑动，同步更新底部导航高亮
        LaunchedEffect(pageState) {
            snapshotFlow { pageState.currentPage }.collect { page ->
                tabState.intValue = page
            }
        }

        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter) {
            HorizontalPager(pageState) {
                when (it) {
                    0 -> HomePage()
                    1 -> SearchPage()
                    2 -> NotificationPage()
                    3 -> ProfilePage()
                }
            }
            BottomNavigation(
                index = tabState.intValue,
                onTabSelected = { index ->
                    scope.launch { pageState.animateScrollToPage(index) }
                },
                onAddClick = {
                    toast("add")
                }
            )
        }
    }

    @Composable
    fun HomePage() {
        Box(modifier = Modifier.fillMaxSize().background(Color(0x80ff0000)))
    }

    @Composable
    fun SearchPage() {
        Box(modifier = Modifier.fillMaxSize().background(Color(0x8000ff00)))
    }

    @Composable
    fun NotificationPage() {
        Box(modifier = Modifier.fillMaxSize().background(Color(0x800000ff)))
    }

    @Composable
    fun ProfilePage() {
        Box(modifier = Modifier.fillMaxSize().background(Color(0x80ff00ff)))
    }

    @Composable
    fun BottomNavigation(
        index: Int,
        onTabSelected: (Int) -> Unit,
        onAddClick: () -> Unit
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(72.dp)
                .background(Color(0x80000000))
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .clickable {
                        onTabSelected(0)
                    }) {
                Image(
                    painter = painterResource(id = R.drawable.twe_ic_nav_home),
                    contentDescription = null,
                    colorFilter = ColorFilter.tint(if (index == 0) ColorTextPrimary else Color.Gray),
                    modifier = Modifier.size(24.dp)
                )
            }
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .clickable {
                        onTabSelected(1)
                    }) {
                Image(
                    painter = painterResource(id = R.drawable.twe_ic_nav_search),
                    contentDescription = null,
                    colorFilter = ColorFilter.tint(if (index == 1) ColorTextPrimary else Color.Gray),
                    modifier = Modifier.size(24.dp)
                )
            }
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .clickable {
                        onAddClick()
                    }) {
                Box(
                    modifier = Modifier
                        .width(48.dp)
                        .height(36.dp)
                        .clip(
                            RoundedCornerShape(12.dp)
                        )
                        .background(ColorTextPrimary)
                )
                Image(
                    painter = painterResource(id = R.drawable.twe_add),
                    contentDescription = null,
                    colorFilter = ColorFilter.tint(ColorTextPrimaryReverse),
                    modifier = Modifier.size(20.dp)
                )
            }
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .clickable {
                        onTabSelected(2)
                    }) {
                Image(
                    painter = painterResource(id = R.drawable.twe_ic_nav_heart),
                    contentDescription = null,
                    colorFilter = ColorFilter.tint(if (index == 2) ColorTextPrimary else Color.Gray),
                    modifier = Modifier.size(24.dp)
                )
            }
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .clickable {
                        onTabSelected(3)
                    }) {
                Image(
                    painter = painterResource(id = R.drawable.twe_ic_nav_profile),
                    contentDescription = null,
                    colorFilter = ColorFilter.tint(if (index == 3) ColorTextPrimary else Color.Gray),
                    modifier = Modifier.size(24.dp)
                )
            }
        }
    }
}
