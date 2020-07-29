package com.dsm.cms.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dsm.cms.R
import com.dsm.cms.data.pref.PrefStorage
import com.dsm.cms.domain.entity.Club
import com.dsm.cms.domain.entity.Post
import com.dsm.cms.domain.entity.Student
import com.dsm.cms.domain.repository.ClubRepository
import com.dsm.cms.domain.repository.PostRepository
import com.dsm.cms.error.exception.BadRequestException
import com.dsm.cms.error.exception.ForbiddenException
import com.dsm.cms.error.exception.NotFoundException
import com.dsm.cms.util.SingleLiveEvent
import kotlinx.coroutines.launch
import java.lang.Exception

class MainViewModel(
    private val clubRepository: ClubRepository,
    private val postRepository: PostRepository,
    private val prefStorage: PrefStorage
) : ViewModel() {
    private val _studentInfo =
        MutableLiveData(Student("", "", "", "", "", ""))
    val studentInfo: LiveData<Student> = _studentInfo

    private val _myClubInfo =
        MutableLiveData(Club("", "동아리에 가입되어 있지 않습니다.", arrayListOf(), "", "미가입"))
    val myClubInfo: LiveData<Club> = _myClubInfo

    private val _clubsInfo = MutableLiveData<List<Club>>(arrayListOf())
    val clubsInfo: LiveData<List<Club>> = _clubsInfo

    private val _recruitments = MutableLiveData<List<Post>>(arrayListOf())
    val recruitments: LiveData<List<Post>> = _recruitments

    private val _notices = MutableLiveData<List<Post>>(arrayListOf())
    val notices: LiveData<List<Post>> = _notices

    private val _resumes = MutableLiveData<List<Post>>(arrayListOf())
    val resumes: LiveData<List<Post>> = _resumes

    private val _toastEvent = SingleLiveEvent<Int>()
    val toastEvent: LiveData<Int> = _toastEvent

    init {
        getServerData()
    }

    private fun getServerData() {
        setStudentInfo()
        setClubInfo(_studentInfo.value?.club!!)
        setClubsInfo()
        setRecruitments()
        setNotices()
        setResumes()
    }

    private fun setStudentInfo() {
        _studentInfo.value = prefStorage.getStudent()
    }

    private fun setClubInfo(clubName: String?) = viewModelScope.launch {
        clubName?.let {
            _myClubInfo.value = clubRepository.getClubInfo(clubName)
        }
    }

    private fun setClubsInfo() = viewModelScope.launch {
        _clubsInfo.value = clubRepository.getClubsInfo()
    }

    private fun setRecruitments() = viewModelScope.launch {
        _recruitments.value = postRepository.getPosts("RECRUITMENT")
    }

    private fun setNotices() = viewModelScope.launch {
        _notices.value = postRepository.getPosts("NOTIFICATION")
    }

    private fun setResumes() = viewModelScope.launch {
        _resumes.value = postRepository.getPosts("RESUME")
    }

    fun offerScout(stdNum: String) = viewModelScope.launch {
        try {
            clubRepository.scoutStudent(
                hashMapOf(
                    "target" to stdNum.substring(0, stdNum.length - 4)
                )
            )
            _toastEvent.value = R.string.success_scout
        } catch (e: Exception) {
            _toastEvent.value = when (e) {
                is BadRequestException -> R.string.fail_exception_notfound
                is ForbiddenException -> R.string.fail_exception_forbidden
                else -> R.string.fail_exception_internal
            }
        }
    }
}