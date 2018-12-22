package ru.nobird.android.ipchain.remote.model

import com.google.gson.annotations.SerializedName

class TransactionShort(
    @SerializedName("transactionID")
    val transactionId: String,
    @SerializedName("type")
    val type: Transaction.Type,
    @SerializedName("createdAt")
    val createdAt: String,
    @SerializedName("createdBy")
    val createdBy: String
)