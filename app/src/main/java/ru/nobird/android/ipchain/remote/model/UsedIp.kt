package ru.nobird.android.ipchain.remote.model

import android.support.annotation.FloatRange
import com.google.gson.annotations.SerializedName

class UsedIp(
    @SerializedName("chID")
    val chId: String,
    @SerializedName("objID")
    val objId: String,
    @SerializedName("trID")
    val trId: String,
    @SerializedName("share")
    @FloatRange(from=0.0, to=1.0)
    val share: Float
) {
}