package ru.nobird.android.ipchain.remote.model

import com.google.gson.JsonElement
import com.google.gson.annotations.SerializedName

class Transaction(
    @SerializedName("type")
    val type: Type? = null,
    @SerializedName("ccID")
    val ccid: String? = null,
    @SerializedName("formatID")
    val formatId: String? = null,
    @SerializedName("objID")
    val objId: String? = null,
    @SerializedName("data")
    val data: JsonElement
) {
    enum class Type {
        A, C
    }
}