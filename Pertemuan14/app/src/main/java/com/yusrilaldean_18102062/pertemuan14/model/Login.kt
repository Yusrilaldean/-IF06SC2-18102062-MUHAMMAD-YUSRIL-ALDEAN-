package com.yusrilaldean_18102062.pertemuan14.model

data class Login(
    @SerializedName("token")
    var token: String? = null,
    @SerializedName("message")
    var message: String? = null
)