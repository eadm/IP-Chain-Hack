package ru.nobird.android.ipchain.remote.model

import com.google.gson.annotations.SerializedName

class ObjectDataTransactions(
    @SerializedName("count")
    val count: Int,
    @SerializedName("transactionList")
    val transactionList: List<TransactionShort>
)