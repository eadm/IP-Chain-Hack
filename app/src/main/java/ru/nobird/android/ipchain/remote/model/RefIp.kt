package ru.nobird.android.ipchain.remote.model

import com.google.gson.annotations.SerializedName

class RefIp(
    @SerializedName("chID")
    val chId: String,
    @SerializedName("refIP")
    val refIp: String
)