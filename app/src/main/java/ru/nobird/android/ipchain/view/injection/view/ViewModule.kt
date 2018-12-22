package ru.nobird.android.ipchain.view.injection.view

import android.arch.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import ru.nobird.android.ipchain.presentation.base.injection.DaggerViewModelFactory

@Module
abstract class ViewModule {

    @Binds
    internal abstract fun bindViewModelFactory(daggerViewModelFactory: DaggerViewModelFactory): ViewModelProvider.Factory

}