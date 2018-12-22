package ru.nobird.android.ipchain.remote.model

import com.google.gson.annotations.SerializedName

class ObjectData(
    @SerializedName("channel")
    val channel: String,
    @SerializedName("key")
    val key: String,
    @SerializedName("record")
    val record: Record
) {
    class Record(
        @SerializedName("name")
        val name: String,
        @SerializedName("type")
        val type: String,
        @SerializedName("alias")
        val alias: String
    )
}