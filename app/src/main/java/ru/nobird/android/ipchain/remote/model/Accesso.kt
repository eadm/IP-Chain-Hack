package ru.nobird.android.ipchain.remote.model

import com.google.gson.JsonElement
import com.google.gson.annotations.SerializedName

class Accesso(
    @SerializedName("actorIP")
    val actorIp: List<Actor>,
    @SerializedName("useMode")
    val useMode: String,
    @SerializedName("doc")
    val doc: Document,
    @SerializedName("lnkTr")
    val lnkTr: List<String>,
    @SerializedName("openDtLnk")
    val openDtLnk: String,
    @SerializedName("getDtLnk")
    val getDtLnk: String,
    @SerializedName("trOthAttr")
    val trOthAttr: JsonElement
)