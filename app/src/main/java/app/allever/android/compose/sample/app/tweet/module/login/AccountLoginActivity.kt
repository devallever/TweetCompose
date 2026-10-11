package app.allever.android.compose.sample.app.tweet.module.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.allever.android.compose.sample.app.tweet.R
import app.allever.android.compose.sample.app.tweet.base.AppBaseActivity
import app.allever.android.compose.sample.app.tweet.ui.theme.ColorIconPrimary
import app.allever.android.compose.sample.app.tweet.ui.theme.ColorPageBgPrimary
import app.allever.android.compose.sample.app.tweet.ui.theme.ColorPageBgPrimaryReverse
import app.allever.android.compose.sample.app.tweet.ui.theme.ColorTextPrimary
import app.allever.android.compose.sample.app.tweet.ui.theme.ColorTextPrimaryReverse
import app.allever.android.lib.core.ext.toast

class AccountLoginActivity : AppBaseActivity() {
    override fun init() {

    }

    @Preview
    @Composable
    override fun Content() {
        val accountState = remember { mutableStateOf("") }
        val passwordState = remember { mutableStateOf("") }
        Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Top) {
            TopBar("账号密码登录")
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
            ) {

                Text(
                    text = "输入账号和密码",
                    color = ColorTextPrimary,
                    modifier = Modifier.padding(vertical = 30.dp)
                )

                Row(
                    modifier = Modifier
                        .padding(vertical = 8.dp)
                        .fillMaxWidth()
                        .height(56.dp)
                        .clip(RoundedCornerShape(19.dp))
                        .background(Color(0x10ffffff))
                        .padding(horizontal = 16.dp), verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.twe_ic_account_login_person),
                        contentDescription = null,
                        modifier = Modifier.size(24.dp),
                        colorFilter = ColorFilter.tint(ColorIconPrimary)
                    )

                    BasicTextField(
                        textStyle = TextStyle(color = ColorTextPrimary),
                        singleLine = true,
                        value = accountState.value,
                        onValueChange = { accountState.value = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 12.dp)
                    ) {
                        if (accountState.value.isEmpty()) {
                            Text(
                                text = "请输入账号", color = Color(0xffb4b4b4)
                            )
                        }
                        it()
                    }
                }

                Row(
                    modifier = Modifier
                        .padding(vertical = 8.dp)
                        .fillMaxWidth()
                        .height(56.dp)
                        .clip(RoundedCornerShape(19.dp))
                        .background(Color(0x10ffffff))
                        .padding(horizontal = 16.dp), verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.twe_ic_phone_login_lock),
                        contentDescription = null,
                        modifier = Modifier.size(24.dp),
                        colorFilter = ColorFilter.tint(ColorIconPrimary)
                    )

                    BasicTextField(
                        textStyle = TextStyle(color = ColorTextPrimary),
                        singleLine = true,
                        value = passwordState.value,
                        onValueChange = { passwordState.value = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 12.dp)
                    ) {
                        if (passwordState.value.isEmpty()) {
                            Text(
                                text = "请输入密码", color = Color(0xffb4b4b4)
                            )
                        }
                        it()
                    }
                }

                FilledTonalButton(
                    onClick = {
                        if (accountState.value.isEmpty() || passwordState.value.isEmpty()) {
                            toast("请输入账号和密码")
                            return@FilledTonalButton
                        }

                        toast("登录成功")
                    },
                    colors = ButtonDefaults.filledTonalButtonColors(ColorPageBgPrimaryReverse),
                    modifier = Modifier
                        .padding(vertical = 20.dp)
                        .fillMaxWidth()
                        .height(56.dp)
                ) {
                    Text(text = "登录", color = ColorTextPrimaryReverse)
                }
            }
        }
    }

    @Preview(showBackground = false)
    @Composable
    fun TopBar(title: String = "") {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
        ) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(
                    text = title,
                    color = ColorTextPrimary,
                    textAlign = TextAlign.Center,
                    fontSize = 17.sp
                )
            }
            Box(modifier = Modifier.fillMaxHeight(), contentAlignment = Alignment.Center) {
                IconButton(onClick = {
                    finish()
                }) {
                    Image(
                        painter = painterResource(id = R.drawable.twe_ic_back),
                        contentDescription = null,
                        colorFilter = ColorFilter.tint(
                            ColorIconPrimary
                        ),
                        modifier = Modifier
                            .size(48.dp)
                            .padding(12.dp)
                    )
                }

            }

        }


    }
}