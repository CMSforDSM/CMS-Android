package com.dsm.cms.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dsm.cms.R
import com.dsm.cms.domain.repository.AuthRepository
import com.dsm.cms.domain.repository.StudentRepository
import com.dsm.cms.util.SingleLiveEvent
import kotlinx.coroutines.launch

class SplashViewModel(
    private val studentRepository: StudentRepository
) : ViewModel() {
    private val _navigateLoginEvent = SingleLiveEvent<Unit>()
    val navigateLoginEvent: LiveData<Unit> = _navigateLoginEvent

    private val _navigateMainEvent = SingleLiveEvent<Unit>()
    val navigateMainEvent: LiveData<Unit> = _navigateMainEvent

    init {
        getStudentInfo()
    }

    private fun getStudentInfo() = viewModelScope.launch {
        try {
            studentRepository.getStudentInfo()

            _navigateMainEvent.call()
        } catch (e: Exception) {
            _navigateLoginEvent.call()
        }
    }
}
