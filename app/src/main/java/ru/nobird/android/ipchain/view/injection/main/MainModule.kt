package ru.nobird.android.ipchain.view.injection.main

import android.arch.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.nobird.android.ipchain.presentation.base.injection.ViewModelKey
import ru.nobird.android.ipchain.presentation.patent.PatentPresenter
import ru.nobird.android.ipchain.presentation.patents.PatentsPresenter

@Module
abstract class MainModule {

    @Binds
    @IntoMap
    @ViewModelKey(PatentsPresenter::class)
    internal abstract fun bindPatentsPresenter(patentsPresenter: PatentsPresenter): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(PatentPresenter::class)
    internal abstract fun bindPatentPresenter(patentPresenter: PatentPresenter): ViewModel

}