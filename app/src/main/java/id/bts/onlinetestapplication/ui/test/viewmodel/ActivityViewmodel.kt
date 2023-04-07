package id.bts.onlinetestapplication.ui.test.viewmodel

import android.text.Editable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import id.bts.onlinetestapplication.network.bin.NetworkServiceHandler
import id.bts.onlinetestapplication.network.module.request.RequestModel
import id.bts.onlinetestapplication.network.module.response.RegisterResponseModel
import id.bts.onlinetestapplication.ui.test.repo.ActivityRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ActivityViewmodel @Inject constructor(
    private val repo: ActivityRepository
): ViewModel() {

    private val _user = MutableLiveData<NetworkServiceHandler<RegisterResponseModel>>()
    val user : LiveData<NetworkServiceHandler<RegisterResponseModel>>
        get() = _user


    fun tryLogin(uname: Editable, password: Editable) {
        viewModelScope.launch {
            repo.userLogin(
                RequestModel(uname.toString(), password.toString())
            ).let {
                _user.postValue(NetworkServiceHandler.loading(null))
                if (it.isSuccessful) {
                    _user.postValue(NetworkServiceHandler.success(it.body()))
                } else {
                    _user.postValue(NetworkServiceHandler.error(it.errorBody().toString(), null))
                }
            }
        }
    }

    fun tryRegister(uname: Editable, password: Editable, email: Editable) {
        viewModelScope.launch {
            repo.userRegistration(
                RequestModel(uname.toString(), password.toString(), email.toString())
            ).let {
                _user.postValue(NetworkServiceHandler.loading(null))
                if (it.isSuccessful) {
                    _user.postValue(NetworkServiceHandler.success(it.body()))
                } else {
                    _user.postValue(NetworkServiceHandler.error(it.errorBody().toString(), null))
                }
            }
        }
    }
}