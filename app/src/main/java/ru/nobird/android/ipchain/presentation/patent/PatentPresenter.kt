package ru.nobird.android.ipchain.presentation.patent

import android.util.Log
import com.google.gson.Gson
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.plusAssign
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import ru.nobird.android.ipchain.domain.usecase.PostTransactionUseCase
import ru.nobird.android.ipchain.presentation.base.PresenterBase
import ru.nobird.android.ipchain.remote.model.Accesso
import ru.nobird.android.ipchain.remote.model.Creazione
import ru.nobird.android.ipchain.remote.model.Transaction
import javax.inject.Inject

class PatentPresenter
@Inject
constructor(
    private val postTransaction: PostTransactionUseCase
) : PresenterBase<PatentView>() {
    private val gson = Gson()


    fun createTransaction(title: String) {
        val cData = Creazione(
            crCodes = listOf(0),
            nameIp = title, // title,
            typeIp = "произвольный тип объекта"
        )

        val cTransaction = postTransaction("proto", transaction = Transaction(
            type = Transaction.Type.C,
            ccid = "C1",
            formatId = "generic",
            data = gson.toJsonTree(cData)
        ))

        val aData = Accesso()

        compositeDisposable += cTransaction
            .flatMap {
                postTransaction("proto", transaction = Transaction(
                    type = Transaction.Type.A,
                    ccid = "A1",
                    formatId = "generic",
                    objId = it.transactionId,
                    data = gson.toJsonTree(aData)
                ))
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(
                onError = { it.printStackTrace() },
                onSuccess = { Log.d("PatentPresenter", gson.toJson(it)) }
            )
    }


}