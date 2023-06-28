package com.hegaro.mvvm.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hegaro.mvvm.data.model.AuthModel
import com.hegaro.mvvm.data.model.AuthResponseModel
import com.hegaro.mvvm.network.AuthServise
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val api:AuthServise
) :ViewModel() {
    //val authModel = MutableLiveData<AuthModel>()
    val authResponseModel = MutableLiveData<AuthResponseModel>()
    val isLoadingResponse = MutableLiveData<Boolean>()
     fun login(authModel: AuthModel){
         isLoadingResponse.postValue(true)
        viewModelScope.launch {
            val response = api.login(authModel)
            println(response.toString())
            authResponseModel.postValue(response)
            isLoadingResponse.postValue(false)
        }

        //this.authModel.postValue(authModel)
    }
}