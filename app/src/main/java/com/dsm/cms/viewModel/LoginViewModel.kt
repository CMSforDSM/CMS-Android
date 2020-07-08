package com.dsm.cms.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dsm.cms.R
import com.dsm.cms.util.SingleLiveEvent

class LoginViewModel : ViewModel() {
    val id = MutableLiveData("")
    val password = MutableLiveData("")

    private val _isLogin = MutableLiveData(false)
    val isLogin: LiveData<Boolean> = _isLogin

    private val _isSucceed = MutableLiveData(false)
    val isSucceed: LiveData<Boolean> = _isSucceed

    private val _toastEvent = SingleLiveEvent<Int>()
    val toastEvent: LiveData<Int> = _toastEvent

    private val _hideKeyEvent = SingleLiveEvent<Unit>()
    val hideKeyEvent: LiveData<Unit> = _hideKeyEvent

    private val _navigateMainEvent = SingleLiveEvent<Unit>()
    val navigateMainEvent: LiveData<Unit> = _navigateMainEvent

    private val _finishLoginEvent = SingleLiveEvent<Unit>()
    val finishLoginEvent: LiveData<Unit> = _finishLoginEvent

    fun onLoginButtonClick() {
        if (!id.value.isNullOrBlank() && !password.value.isNullOrBlank()) {
            _toastEvent.value = R.string.success_login
            _isSucceed.value = true

            _hideKeyEvent.call()
            _navigateMainEvent.call()
            _finishLoginEvent.call()
        } else {
            _toastEvent.value = R.string.check_id_pw
            _isSucceed.value = false
        }
    }
}
