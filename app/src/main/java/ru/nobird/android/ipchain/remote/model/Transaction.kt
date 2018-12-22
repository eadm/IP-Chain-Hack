package ru.nobird.android.ipchain.remote.model

import com.google.gson.JsonElement
import com.google.gson.annotations.SerializedName

class Transaction(
    @SerializedName("type")
    val type: Type,
    @SerializedName("ccID")
    val ccid: String,
    @SerializedName("formatID")
    val formatId: String,
    @SerializedName("objID")
    val objId: String,
    @SerializedName("data")
    val data: JsonElement
) {
    enum class Type {
        A, C
    }
}