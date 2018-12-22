package ru.nobird.android.ipchain.view.injection

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.nobird.android.ipchain.view.injection.main.MainModule
import ru.nobird.android.ipchain.view.injection.remote.RemoteModule
import ru.nobird.android.ipchain.view.injection.view.ViewModule
import ru.nobird.android.ipchain.view.patents.ui.activity.PatentsActivity

@Component(modules = [
    RemoteModule::class,

    ViewModule::class,
    MainModule::class
])
interface AppComponent {

    @Component.Builder
    interface Builder {
        fun build(): AppComponent

        @BindsInstance
        fun context(context: Context): Builder
    }

    fun inject(mainActivity: PatentsActivity)

}