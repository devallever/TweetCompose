package app.allever.android.compose.sample.app.tweet

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.allever.android.compose.sample.app.tweet.base.AppBaseActivity
import app.allever.android.compose.sample.app.tweet.module.login.AccountLoginActivity
import app.allever.android.compose.sample.app.tweet.module.login.LoginActivity
import app.allever.android.compose.sample.app.tweet.module.main.MainActivity
import app.allever.android.compose.sample.app.tweet.ui.theme.ColorTextPrimary
import app.allever.android.lib.core.helper.ActivityHelper

class DebugActivity : AppBaseActivity() {
    override fun init() {

    }

    @Preview
    @Composable
    override fun Content() {
        val functionList = mutableListOf<FunctionItem>().apply {
            add(FunctionItem("登录页") {
                ActivityHelper.startActivity<LoginActivity>()
            })
            add(FunctionItem("密码登录页") {
                ActivityHelper.startActivity<AccountLoginActivity>()
            })
            add(FunctionItem("主页") {
                ActivityHelper.startActivity<MainActivity>()
            })
        }

        val rememberFunctionList = remember { functionList }

        LazyColumn(modifier = Modifier.fillMaxSize()) {
            itemsIndexed(rememberFunctionList) { index, functionItem ->
                Column(modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp)
                    .clickable {
                        functionItem.action.invoke()
                    }) {
                    Text(
                        textAlign = TextAlign.Center,
                        text = functionItem.title,
                        fontSize = 17.sp,
                        color = ColorTextPrimary,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .padding(5.dp)
                            .fillMaxWidth()
                    )
                    if (functionItem.desc.isNotEmpty()) {
                        Text(
                            textAlign = TextAlign.Center,
                            text = functionItem.desc,
                            color = ColorTextPrimary,
                            fontSize = 15.sp,
                            modifier = Modifier
                                .padding(5.dp)
                                .fillMaxWidth()
                        )
                    }

                }
            }
        }
    }
}

class FunctionItem(
    val title: String = "", val desc: String = "", val action: () -> Unit = {}
)