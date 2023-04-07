package id.bts.onlinetestapplication.ui.test.repo

import id.bts.onlinetestapplication.network.module.request.RequestModel
import id.bts.onlinetestapplication.network.service.UserService
import javax.inject.Inject

class ActivityRepository @Inject constructor(private val userService: UserService) {

    suspend fun userRegistration(
        requestModel: RequestModel
    ) =
        userService.registerLogin(
            requestModel
        )

    suspend fun userLogin(
        requestModel: RequestModel
    ) =
        userService.registerLogin(
            requestModel
        )
}