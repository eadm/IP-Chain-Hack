package ru.nobird.android.ipchain.remote.model

import com.google.gson.annotations.SerializedName

class TransactionRegistred(
    @SerializedName("transactionID")
    val transactionId: String,
    @SerializedName("timestamp")
    val timestamp: String,
    @SerializedName("actions")
    val actions: List<Action>
)