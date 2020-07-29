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
import com.dsm.cms.util.SingleLiveEvent
import kotlinx.coroutines.launch

class ClubViewModel(
    private val beforeClub: Club,
    private val clubRepository: ClubRepository,
    private val postRepository: PostRepository,
    private val prefStorage: PrefStorage
) : ViewModel() {
    private val _detailClub = MutableLiveData(Club("", "", arrayListOf(), "", ""))
    val detailClub: LiveData<Club> = _detailClub

    private val _studentInfo =
        MutableLiveData(Student("", "", "", "", "", ""))
    val studentInfo: LiveData<Student> = _studentInfo

    private val _posts = MutableLiveData<List<Post>>(emptyList())
    val posts: LiveData<List<Post>> = _posts

    private val _toastEvent = SingleLiveEvent<Int>()
    val toastEvent: LiveData<Int> = _toastEvent

    init {
        getStudentInfo()
        getDetailClubInfo()
        getClubsPosts()
    }

    private fun getDetailClubInfo() = viewModelScope.launch {
        _detailClub.value = clubRepository.getClubInfo(beforeClub.clubName)
    }

    private fun getStudentInfo() = viewModelScope.launch {
        _studentInfo.value = prefStorage.getStudent()
    }

    private fun getClubsPosts() = viewModelScope.launch {
        _posts.value = postRepository.getPosts("ACHIEVEMENT", beforeClub.clubName)
    }

    fun applyClub() = viewModelScope.launch {
        try {
            clubRepository.applyClub(
                hashMapOf(
                    "club_name" to beforeClub.clubName
                )
            )

            _toastEvent.value = R.string.success_apply
        } catch (e: Exception) {
            _toastEvent.value = R.string.fail_exception_internal
        }
    }
}