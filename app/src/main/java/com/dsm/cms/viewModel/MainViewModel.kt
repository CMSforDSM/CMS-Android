package com.dsm.cms.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dsm.cms.data.pref.PrefStorage
import com.dsm.cms.domain.entity.Club
import com.dsm.cms.domain.entity.Student
import com.dsm.cms.domain.repository.ClubRepository
import kotlinx.coroutines.launch

class MainViewModel(
    private val clubRepository: ClubRepository,
    private val prefStorage: PrefStorage
) : ViewModel() {
    private val _studentInfo =
        MutableLiveData(Student("", "", "", "", "", ""))
    val studentInfo: LiveData<Student> = _studentInfo

    private val _myClubInfo =
        MutableLiveData(Club("", "", arrayListOf(), "", ""))
    val myClubInfo: LiveData<Club> = _myClubInfo

    private val _clubsInfo = MutableLiveData<List<Club>>(arrayListOf())
    val clubsInfo: LiveData<List<Club>> = _clubsInfo

    init {
        setStudentInfo()
        setClubInfo(_studentInfo.value?.club!!)
        setClubsInfo()
    }

    private fun setStudentInfo() {
        _studentInfo.value = prefStorage.getStudent()
    }

    private fun setClubInfo(clubName: String) = viewModelScope.launch {
        _myClubInfo.value = clubRepository.getClubInfo(clubName)
    }

    private fun setClubsInfo() = viewModelScope.launch {
        _clubsInfo.value = clubRepository.getClubsInfo()
    }

}