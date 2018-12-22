package ru.nobird.android.ipchain

import android.app.Application
import com.facebook.stetho.Stetho
import ru.nobird.android.ipchain.view.injection.AppComponent
import ru.nobird.android.ipchain.view.injection.DaggerAppComponent

class App : Application() {
    companion object {
        private lateinit var _component: AppComponent

        val component: AppComponent
            get() = _component
    }

    override fun onCreate() {
        super.onCreate()

        _component = DaggerAppComponent
            .builder()
            .context(this)
            .build()

        Stetho.initializeWithDefaults(this)
    }
}