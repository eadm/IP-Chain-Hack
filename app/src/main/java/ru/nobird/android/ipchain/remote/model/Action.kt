package ru.nobird.android.ipchain.remote.model

import com.google.gson.annotations.SerializedName

class Action(
    @SerializedName("member")
    val member: Member,
    @SerializedName("memberID")
    val memberId: String,
    @SerializedName("type")
    val type: Type
) {
    enum class Member { actor, IPRight }
    enum class Type { created, updated, deleted, used }
}