package com.gemasr.composeada.data.remote.response

import com.google.gson.annotations.SerializedName

data class Sprites(
    @SerializedName("front_default")
    val frontDefault: String
)