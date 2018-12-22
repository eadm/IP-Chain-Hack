package ru.nobird.android.ipchain.remote.service

import io.reactivex.Single
import retrofit2.http.*
import ru.nobird.android.ipchain.remote.model.ObjectData
import ru.nobird.android.ipchain.remote.model.ObjectDataTransactions
import ru.nobird.android.ipchain.remote.model.Transaction
import ru.nobird.android.ipchain.remote.model.TransactionRegistred

interface RestService {
    @POST("/{channelID}/transactions")
    fun postTransaction(
        @Path("channelID") channelId: String,
        @Body transaction: Transaction
    ): Single<TransactionRegistred>

    @GET("/{channelID}/transactions/{transactionID}")
    fun getTransaction(
        @Path("transactionID") transactionId: String,
        @Path("channelID") channelId: String
    ): Single<Transaction>

    @GET("/{channelID}/objects/{objectID}/transactions")
    fun getTransactionByObject(
        @Path("objectID") objectId: String,
        @Path("channelID") channelId: String
    ): Single<ObjectDataTransactions>

    @GET("/search/objects/IPObject/")
    fun getObjectsByName(@Query("name") name: String): Single<List<ObjectData>>

    @GET("/objects/types")
    fun getObjectTypes(): Single<List<String>>
}