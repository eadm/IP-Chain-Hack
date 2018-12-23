package ru.nobird.android.ipchain.remote.model

import com.google.gson.JsonElement
import com.google.gson.annotations.SerializedName

class Accesso(
    @SerializedName("actorIP")
    val actorIp: List<Actor>? = null,
    @SerializedName("useMode")
    val useMode: String? = null,
    @SerializedName("doc")
    val doc: Document? = null,
    @SerializedName("lnkTr")
    val lnkTr: List<String>? = null,
    @SerializedName("openDtLnk")
    val openDtLnk: String? = null,
    @SerializedName("getDtLnk")
    val getDtLnk: String? = null,
    @SerializedName("trOthAttr")
    val trOthAttr: JsonElement? = null
)