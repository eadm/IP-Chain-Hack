package ru.nobird.android.ipchain.remote.model

import com.google.gson.JsonElement
import com.google.gson.annotations.SerializedName

class Creazione(
    @SerializedName("crCodes")
    val crCodes: List<Int>? = null,
    @SerializedName("nameIP")
    val nameIp: String? = null,
    @SerializedName("typeIP")
    val typeIp: String? = null,
    @SerializedName("created")
    val created: String? = null,
    @SerializedName("usedIP")
    val usedIp: List<UsedIp>? = null,
    @SerializedName("refIP")
    val refIp: List<RefIp>? = null,
    @SerializedName("actorIP")
    val actorIp: List<Actor>? = null,
    @SerializedName("depLnk")
    val depLnk: String? = null,
    @SerializedName("openDtLnk")
    val openDtLnk: String? = null,
    @SerializedName("openDtHash")
    val openDtHash: String? = null,
    @SerializedName("description")
    val description: String? = null,
    @SerializedName("orgID")
    val orgId: String? = null,
    @SerializedName("trOthAttr")
    val trOthAttr: JsonElement? = null
)