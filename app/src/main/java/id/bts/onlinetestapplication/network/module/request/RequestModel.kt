package id.bts.onlinetestapplication.network.module.request


import com.fasterxml.jackson.annotation.JsonProperty

data class RequestModel(@JsonProperty("password")
                                val password: String = "",
                        @JsonProperty("email")
                                val email: String = "",
                        @JsonProperty("username")
                                val username: String = "")


