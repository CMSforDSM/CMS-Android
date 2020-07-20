package com.dsm.cms.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dsm.cms.R
import com.dsm.cms.domain.repository.AuthRepository
import com.dsm.cms.domain.repository.StudentRepository
import com.dsm.cms.util.SingleLiveEvent
import kotlinx.coroutines.launch

class LoginViewModel(
    private val authRepository: AuthRepository,
    private val studentRepository: StudentRepository
) : ViewModel() {
    val id = MutableLiveData("")
    val password = MutableLiveData("")

    private val _isLogin = MutableLiveData(false)
    val isLogin: LiveData<Boolean> = _isLogin

    private val _toastEvent = SingleLiveEvent<Int>()
    val toastEvent: LiveData<Int> = _toastEvent

    private val _hideKeyEvent = SingleLiveEvent<Unit>()
    val hideKeyEvent: LiveData<Unit> = _hideKeyEvent

    private val _navigateMainEvent = SingleLiveEvent<Unit>()
    val navigateMainEvent: LiveData<Unit> = _navigateMainEvent

    private val _finishLoginEvent = SingleLiveEvent<Unit>()
    val finishLoginEvent: LiveData<Unit> = _finishLoginEvent

    fun onLoginButtonClick() = viewModelScope.launch {
        if (!id.value.isNullOrBlank() && !password.value.isNullOrBlank()) {
            _isLogin.postValue(true)
            try {
                authRepository.login(
                    hashMapOf(
                        "id" to id.value,
                        "password" to password.value
                    )
                )

                studentRepository.setStudentInfo()

                _toastEvent.value = R.string.success_login

                _hideKeyEvent.call()
                _navigateMainEvent.call()
                _finishLoginEvent.call()
            } catch (e: Exception) {
                _toastEvent.value = R.string.fail_login
            }
            _isLogin.postValue(false)
        } else {
            _toastEvent.value = R.string.check_id_pw
        }
    }
}