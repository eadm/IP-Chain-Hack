package ru.nobird.android.ipchain.remote.source

import io.reactivex.Single
import ru.nobird.android.ipchain.remote.model.*
import ru.nobird.android.ipchain.remote.service.RestService
import javax.inject.Inject

class RemoteDataSourceImpl
@Inject
constructor(
    private val restService: RestService
) {
    fun postTransaction(channelId: String, transaction: Transaction): Single<TransactionRegistred> =
        restService.postTransaction(channelId, transaction)

    fun getTransaction(transactionId: String, channelId: String): Single<Transaction> =
        restService.getTransaction(transactionId, channelId)

    fun getTransactionByObject(objectId: String, channelId: String): Single<ObjectDataTransactions> =
        restService.getTransactionByObject(objectId, channelId)

    fun getObjectsByName(name: String): Single<List<ObjectData>> =
        restService.getObjectsByName(name)

    fun getObjectTypes(): Single<List<String>> =
        restService.getObjectTypes()
}