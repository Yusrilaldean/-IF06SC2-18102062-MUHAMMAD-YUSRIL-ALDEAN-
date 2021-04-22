package com.yusrilaldean_18102062.pertemuan14.model

<<<<<<< Updated upstream
=======
import com.google.gson.annotations.SerializedName

>>>>>>> Stashed changes
data class Login(
    @SerializedName("token")
    var token: String? = null,
    @SerializedName("message")
    var message: String? = null
)