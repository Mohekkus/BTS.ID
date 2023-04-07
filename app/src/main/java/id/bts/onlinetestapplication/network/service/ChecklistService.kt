package id.bts.onlinetestapplication.network.service

import id.bts.onlinetestapplication.network.bin.ModuleInfo
import id.bts.onlinetestapplication.network.module.request.RequestModel
import id.bts.onlinetestapplication.network.module.response.RegisterResponseModel
import retrofit2.Response
import retrofit2.http.*

interface ChecklistService {

    @POST(ModuleInfo.checklist)
    suspend fun getCheckList() : Response<RegisterResponseModel>

    @POST(ModuleInfo.checklist)
    suspend fun createCheckList(
        @Body access: RequestModel
    ) : Response<RegisterResponseModel>

    @DELETE(ModuleInfo.checklist)
    suspend fun deleteCheckList(
        @Url url: Int
    ) : Response<RegisterResponseModel>


    @GET
    suspend fun getCheckListItem(
        @Url url: String
    ) : Response<RegisterResponseModel>


    @PUT
    suspend fun updateCheckListItem(
        @Url url: String
    ) : Response<RegisterResponseModel>


    @DELETE
    suspend fun deleteCheckListItem(
        @Url url: String
    ) : Response<RegisterResponseModel>

    @POST
    suspend fun createCheckListItem(
        @Url url: String,
        @Body access: RequestModel
    ) : Response<RegisterResponseModel>
}