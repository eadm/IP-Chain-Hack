package ru.nobird.android.ipchain.presentation.patent

import ru.nobird.android.ipchain.view.patent.model.Item

interface PatentView {
    fun showLoading()
    fun hideLoading()
    fun onSuccess(item: Item)
    fun onError()
}