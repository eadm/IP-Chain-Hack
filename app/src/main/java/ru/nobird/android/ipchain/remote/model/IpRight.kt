package ru.nobird.android.ipchain.remote.model

import android.support.annotation.FloatRange
import com.google.gson.annotations.SerializedName

class IpRight (
    @SerializedName("IPRightID")
    val ipRightId: String,
    @SerializedName("territory")
    val territory: String, // ISO 3166
    @SerializedName("rights")
    val rights: String,
    @SerializedName("dateFrom")
    val dateFrom: String,
    @SerializedName("dateTo")
    val dateTo: String,
    @FloatRange(from=0.0,to=1.0)
    @SerializedName("contributionWeight")
    val contributionWeight: Float,
    @SerializedName("orgID")
    val orgId: String
)
