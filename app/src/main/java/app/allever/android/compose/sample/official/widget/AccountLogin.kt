package app.allever.android.compose.sample.official.widget

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
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.allever.android.compose.sample.app.tweet.R
import app.allever.android.compose.sample.app.tweet.ui.theme.ColorIconPrimary
import app.allever.android.compose.sample.app.tweet.ui.theme.ColorPageBgPrimaryReverse
import app.allever.android.compose.sample.app.tweet.ui.theme.ColorTextPrimary
import app.allever.android.compose.sample.app.tweet.ui.theme.ColorTextPrimaryReverse

@Composable
fun AccountLogin(
    account: String,
    password: String,
    onAccountChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onLogin: () -> Unit
) {
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
                value = account,
                onValueChange = { onAccountChange(it) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp)
            ) {
                if (account.isEmpty()) {
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
                value = password,
                onValueChange = {
                    onPasswordChange(it)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp)
            ) {
                if (password.isEmpty()) {
                    Text(
                        text = "请输入密码", color = Color(0xffb4b4b4)
                    )
                }
                it()
            }
        }

        FilledTonalButton(
            onClick = {
//                        if (uiState.account.isEmpty() || uiState.password.isEmpty()) {
//                            toast("请输入账号和密码")
//                            return@FilledTonalButton
//                        }

                onLogin()
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