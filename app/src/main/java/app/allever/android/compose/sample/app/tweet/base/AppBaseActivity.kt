package app.allever.android.compose.sample.app.tweet.base

import android.os.Bundle
import androidx.activity.ComponentActivity
import app.allever.android.lib.core.helper.ActivityHelper
import java.lang.ref.WeakReference

open class AppBaseActivity: ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ActivityHelper.add(WeakReference(this))
    }


    override fun onResume() {
        super.onResume()
        ActivityHelper.onResume(this)
    }
    override fun onDestroy() {
        super.onDestroy()
        ActivityHelper.remove(WeakReference(this))
    }
}