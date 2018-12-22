package ru.nobird.android.ipchain.remote.model

import com.google.gson.JsonElement
import com.google.gson.annotations.SerializedName

class Creazione(
    @SerializedName("crCodes")
    val crCodes: Int,
    @SerializedName("nameIP")
    val nameIp: String,
    @SerializedName("typeIP")
    val typeIp: String,
    @SerializedName("created")
    val created: String,
    @SerializedName("usedIP")
    val usedIp: List<UsedIp>,
    @SerializedName("refIP")
    val refIp: List<RefIp>,
    @SerializedName("actorIP")
    val actorIp: List<Actor>,
    @SerializedName("depLnk")
    val depLnk: String,
    @SerializedName("openDtLnk")
    val openDtLnk: String,
    @SerializedName("openDtHash")
    val openDtHash: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("orgID")
    val orgId: String,
    @SerializedName("trOthAttr")
    val trOthAttr: JsonElement
)