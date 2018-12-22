package ru.nobird.android.ipchain.presentation.main

import android.util.Log
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.plusAssign
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import ru.nobird.android.ipchain.domain.usecase.GetObjectTypesUseCase
import ru.nobird.android.ipchain.presentation.base.PresenterBase
import javax.inject.Inject

class MainPresenter
@Inject
constructor(
    private val getObjectTypes: GetObjectTypesUseCase
): PresenterBase<MainView>() {

    fun fetchObjectTypes() {
        compositeDisposable += getObjectTypes()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy({
                it.printStackTrace()
            }, {
                Log.d("MainPresenter", it.joinToString())
            })
    }

}