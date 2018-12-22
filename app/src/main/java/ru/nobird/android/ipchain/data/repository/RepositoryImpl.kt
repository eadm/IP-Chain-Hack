package ru.nobird.android.ipchain.data.repository

import io.reactivex.Single
import ru.nobird.android.ipchain.remote.model.ObjectData
import ru.nobird.android.ipchain.remote.model.ObjectDataTransactions
import ru.nobird.android.ipchain.remote.model.Transaction
import ru.nobird.android.ipchain.remote.model.TransactionRegistred
import ru.nobird.android.ipchain.remote.source.RemoteDataSourceImpl
import javax.inject.Inject

class RepositoryImpl
@Inject
constructor(
    private val remoteDataSourceImpl: RemoteDataSourceImpl
) {

    fun postTransaction(channelId: String, transaction: Transaction): Single<TransactionRegistred> =
        remoteDataSourceImpl.postTransaction(channelId, transaction)

    fun getTransaction(transactionId: String, channelId: String): Single<Transaction> =
        remoteDataSourceImpl.getTransaction(transactionId, channelId)

    fun getTransactionByObject(objectId: String, channelId: String): Single<ObjectDataTransactions> =
        remoteDataSourceImpl.getTransactionByObject(objectId, channelId)

    fun getObjectsByName(name: String): Single<List<ObjectData>> =
        remoteDataSourceImpl.getObjectsByName(name)

    fun getObjectTypes(): Single<List<String>> =
        remoteDataSourceImpl.getObjectTypes()

}