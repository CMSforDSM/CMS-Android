package com.dsm.cms.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dsm.cms.data.pref.PrefStorage
import com.dsm.cms.domain.entity.Student

class MainViewModel(
    private val prefStorage: PrefStorage
) : ViewModel() {
    private val _studentInfo = MutableLiveData(Student("", "", "홍성하", "", "", "HELLO MY NAME IS SEONGHA"))
    val studentInfo: LiveData<Student> = _studentInfo

    init {
        setStudentInfo()
    }

    private fun setStudentInfo() {
        _studentInfo.postValue(prefStorage.getStudent())
    }
}