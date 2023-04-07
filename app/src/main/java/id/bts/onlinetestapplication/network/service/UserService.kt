package id.bts.onlinetestapplication.network.service

import id.bts.onlinetestapplication.network.module.request.RequestModel
import id.bts.onlinetestapplication.network.module.response.RegisterResponseModel
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface UserService {

    @POST
    suspend fun registerLogin(
        @Body access: RequestModel
    ) : Response<RegisterResponseModel>
}