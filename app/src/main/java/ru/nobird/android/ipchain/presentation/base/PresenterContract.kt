package ru.nobird.android.ipchain.presentation.base

interface PresenterContract<V> {
    fun attachView(view: V)
    fun detachView(view: V)
}
