package app.allever.android.compose.sample.app.tweet.module.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.allever.android.compose.sample.app.tweet.R
import app.allever.android.compose.sample.app.tweet.base.AppBaseActivity
import app.allever.android.compose.sample.app.tweet.ui.theme.ColorIconPrimary
import app.allever.android.compose.sample.app.tweet.ui.theme.ColorIconPrimaryReverse
import app.allever.android.compose.sample.app.tweet.ui.theme.ColorTextPrimary
import app.allever.android.compose.sample.app.tweet.ui.theme.TweetComposeTheme
import app.allever.android.lib.core.ext.toast
import app.allever.android.lib.core.helper.ActivityHelper

class LoginActivity : AppBaseActivity() {

    override fun init() {

    }

    @Composable
    override fun Content() {
        var checkState by remember { mutableStateOf(false) }
        Box(modifier = Modifier.fillMaxSize()) {
            Text(
                text = getString(R.string.app_name),
                fontWeight = FontWeight.Bold,
                color = ColorTextPrimary,
                fontSize = 35.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(vertical = 80.dp)
                    .fillMaxWidth()
            )
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.BottomCenter
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 10.dp, start = 26.dp, end = 26.dp)
                ) {
                    LoginButton(
                        "谷歌登录", R.drawable.twe_ic_login_google
                    ) { toast("谷歌登录") }
                    LoginButton(
                        "使用手机号登录", R.drawable.twe_ic_login_phone
                    ) { toast("手机号登录") }
                    LoginButton("使用账号密码登录", R.drawable.twe_ic_login_person) {
                        if (!checkState) {
                            toast("请同意并勾选用户协议和隐私条款")
                            return@LoginButton
                        }

                        ActivityHelper.startActivity<AccountLoginActivity>()


                    }
                    LoginButton("创建新账号", R.drawable.twe_ic_login_person_add) {
                        toast(
                            "创建账号"
                        )
                    }
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {

                        Checkbox(
                            checked = checkState, onCheckedChange = {
                                checkState = it
                            }, colors = CheckboxDefaults.colors(
                                checkedColor = ColorIconPrimary,
                                checkmarkColor = ColorIconPrimaryReverse

                            ), modifier = Modifier
                        )
                        Text(
                            text = "我已阅读并同意",
                            fontSize = 12.sp,
                            color = ColorTextPrimary
                        )
                        Text(
                            text = "《用户协议》",
                            fontSize = 12.sp,
                            color = Color(0xFF0000FF),
                            modifier = Modifier.clickable {
                                toast("点击了用户协议")
                            })
                        //和
                        Text(text = "和", fontSize = 12.sp, color = ColorTextPrimary)
                        Text(
                            text = "《隐私政策》",
                            fontSize = 12.sp,
                            color = Color(0xFF0000FF),
                            modifier = Modifier.clickable {
                                toast("点击了隐私政策")
                            })
                    }
                }
            }
        }


    }


}

@Composable
fun LoginButton(text: String, icon: Int, click: () -> Unit) {
    OutlinedButton(
        onClick = click, colors = ButtonDefaults.buttonColors(
            containerColor = Color(0x20ffffff),
        ), modifier = Modifier
            .padding(vertical = 8.dp)
            .fillMaxWidth()
            .height(56.dp)
    ) {
        Image(
            painter = painterResource(id = icon), colorFilter = ColorFilter.tint(
                ColorIconPrimary
            ), contentDescription = null, modifier = Modifier.size(24.dp)
        )
        Text(
            text = text, modifier = Modifier.padding(start = 10.dp), color = ColorTextPrimary
        )
    }
}

@Preview(showBackground = false)
@Composable
fun GreetingPreview() {
    TweetComposeTheme {
        Column {
            LoginButton(
                "手机号登录", R.drawable.twe_ic_login_phone
            ) { toast("手机号登录") }
            LoginButton("账号密码登录", R.drawable.twe_ic_login_person) {
                toast(
                    "账号密码登录"
                )
            }
        }

    }
}