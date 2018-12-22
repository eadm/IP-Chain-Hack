package ru.nobird.android.ipchain.remote.model

import com.google.gson.JsonElement
import com.google.gson.annotations.SerializedName

class TransactionData(
    @SerializedName("transactionID")
    val transactionId: String,
    @SerializedName("txContent")
    val txContent: JsonElement,
    @SerializedName("createdAt")
    val createdAt: String,
    @SerializedName("createdBy")
    val createdBy: String
)