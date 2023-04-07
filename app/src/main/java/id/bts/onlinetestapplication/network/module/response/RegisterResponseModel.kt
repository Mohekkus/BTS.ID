package id.bts.onlinetestapplication.network.module.response


import com.fasterxml.jackson.annotation.JsonProperty

data class RegisterResponseModel(@JsonProperty("data")
                                 val data: Data,
                                 @JsonProperty("errorMessage")
                                 val errorMessage: String = "",
                                 @JsonProperty("message")
                                 val message: String = "",
                                 @JsonProperty("statusCode")
                                 val statusCode: Int = 0)


data class Data(@JsonProperty("token")
                val token: String = "")


