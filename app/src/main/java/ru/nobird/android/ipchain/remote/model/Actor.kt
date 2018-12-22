package ru.nobird.android.ipchain.remote.model

import com.google.gson.annotations.SerializedName

class Actor(
    @SerializedName("actorID")
    val actorId: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("IPRights")
    val ipRights: List<IpRight>,
    @SerializedName("status")
    val status: String,
    @SerializedName("orgID")
    val orgId: String
)