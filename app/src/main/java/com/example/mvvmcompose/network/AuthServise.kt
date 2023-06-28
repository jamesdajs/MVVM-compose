package com.hegaro.mvvm.network

import com.hegaro.mvvm.data.model.AuthModel
import com.hegaro.mvvm.data.model.AuthResponseModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AuthServise @Inject constructor(
    private val apiAuth : AuthHandler
) {

    suspend fun login(authModel: AuthModel): AuthResponseModel {
        return withContext(Dispatchers.IO) {
            val response = apiAuth.loginUser(authModel)

                response.body()?: AuthResponseModel(ok = false,user = null,token = "")

        }
    }
}