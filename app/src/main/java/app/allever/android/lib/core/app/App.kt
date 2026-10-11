package app.allever.android.lib.core.app

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context

open class App: Application() {
    companion object {
        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context
        lateinit var app: Application
        const val DEBUG = true
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
        app = this
    }
}