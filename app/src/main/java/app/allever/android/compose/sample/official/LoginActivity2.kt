package app.allever.android.compose.sample.official

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.allever.android.compose.sample.app.tweet.base.AppBaseActivity
import app.allever.android.compose.sample.official.widget.AccountLogin
import app.allever.android.compose.sample.official.widget.TopBar
import app.allever.android.lib.core.ext.log
import app.allever.android.lib.core.ext.toast
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LoginActivity2 : AppBaseActivity() {

    private val viewModel by lazy { LoginViewModel2() }


    override fun init() {

    }

    @Preview
    @Composable
    override fun Content() {
        LaunchedEffect(Unit) {

        }


//        val loginLiveData = viewModel.loginLiveData.observeAsState()
//        loginLiveData.value?.let {
//            finish()
//        }
        viewModel.loginLiveData.observe(this) {
            if (it) {
                finish()
            }
        }


        val accountState = viewModel.accountState
        val passwordState = viewModel.passwordState
        Column(modifier = Modifier.fillMaxSize()) {
            //appbar
            TopBar("账号密码登录") {
                finish()
            }
            AccountLogin(
                accountState.value,
                passwordState.value.text,
                { accountState.value = it },
                { passwordState.value = TextFieldValue(it) }) {
                viewModel.login()
            }
        }
    }


    class LoginViewModel2 : ViewModel() {
        val accountState = mutableStateOf("")
        val passwordState = mutableStateOf(TextFieldValue(""))
        
        val loginLiveData = MutableLiveData<Boolean>()

        fun login() {
            if (accountState.value.isEmpty() || passwordState.value.text.isEmpty()) {
                toast("账号密码不能为空")
                return
            }
            viewModelScope.launch {
                delay(2000)
                toast("登录成功")
                loginLiveData.postValue(true)
            }
        }

    }
}