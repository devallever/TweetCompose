package app.allever.android.compose.sample.official

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.allever.android.compose.sample.app.tweet.base.AppBaseActivity
import app.allever.android.compose.sample.official.widget.AccountLogin
import app.allever.android.compose.sample.official.widget.TopBar
import app.allever.android.lib.core.ext.toast
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class LoginActivity : AppBaseActivity() {

    private val viewModel by lazy { AccountLoginViewModel() }
    override fun init() {

    }

    @Preview
    @Composable
    override fun Content() {
        LaunchedEffect(Unit) {
            viewModel.event.collect { event ->
                when (event) {
                    is AccountLoginOnceEvent.LoginSuccess -> {
                        finish()
                    }
                }
            }
        }
        val uiState = viewModel.uiState
        Column(modifier = Modifier.fillMaxSize()) {
            TopBar("账号密码登录") {
                finish()
            }
            AccountLogin(uiState.account, uiState.password, {
                viewModel.dispatchEvent(
                    AccountLoginEvent.UpdateAccount(it)
                )
            }, {
                viewModel.dispatchEvent(
                    AccountLoginEvent.UpdatePassword(it)
                )
            }, {
                viewModel.dispatchEvent(
                    AccountLoginEvent.Login
                )
            })
        }
    }


    data class AccountLoginUiState(
        val account: String = "", val password: String = "", val isLogged: Boolean = false
    )

    class AccountLoginViewModel : ViewModel() {

        var uiState by mutableStateOf(AccountLoginUiState())
            private set

        private var _event = Channel<AccountLoginOnceEvent>(Channel.BUFFERED)
        val event = _event.receiveAsFlow()

        fun dispatchEvent(event: AccountLoginEvent) {
            when (event) {
                is AccountLoginEvent.Login -> {
                    viewModelScope.launch {
                        if (uiState.account.isEmpty() || uiState.password.isEmpty()) {
                            toast("请输入账号和密码")
                            return@launch
                        }
                        delay(2000)
                        toast("登录成功")
                        _event.send(AccountLoginOnceEvent.LoginSuccess)
                    }
                }

                is AccountLoginEvent.UpdateAccount -> {
                    uiState = uiState.copy(account = event.account)
                }

                is AccountLoginEvent.UpdatePassword -> {
                    uiState = uiState.copy(password = event.password)
                }
            }
        }

    }

    sealed class AccountLoginOnceEvent {
        object LoginSuccess : AccountLoginOnceEvent()
    }

    sealed class AccountLoginEvent() {
        object Login : AccountLoginEvent()
        data class UpdateAccount(val account: String) : AccountLoginEvent()
        data class UpdatePassword(val password: String) : AccountLoginEvent()
    }

}

