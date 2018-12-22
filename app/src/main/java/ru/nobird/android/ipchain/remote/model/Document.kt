package ru.nobird.android.ipchain.remote.model

import com.google.gson.annotations.SerializedName

class Document(
    @SerializedName("docNum")
    val docNum: String,
    @SerializedName("docDate")
    val docDate: String,
    @SerializedName("docLnk")
    val docLnk: String,
    @SerializedName("docHash")
    val docHash: String
)