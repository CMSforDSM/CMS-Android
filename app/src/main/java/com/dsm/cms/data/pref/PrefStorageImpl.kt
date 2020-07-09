package com.dsm.cms.data.pref

import android.content.Context
import android.content.SharedPreferences
import com.dsm.cms.domain.entity.Student
import com.google.gson.Gson
import com.google.gson.JsonParser

class PrefStorageImpl(context: Context) : PrefStorage {

    companion object {
        private const val PREF_NAME = "PREF_USER"
        private const val PREF_ACCESS_TOKEN = "PREF_ACCESS_TOKE"
        private const val PREF_REFRESH_TOKEN = "PREF_REFRESH_TOKEN"
        private const val PREF_STUDENT = "PREF_STUDENT"
    }

    private val pref: SharedPreferences by lazy {
        context.getSharedPreferences(
            PREF_NAME,
            Context.MODE_PRIVATE
        )
    }

    // token

    override fun setAccessToken(accessToken: String) =
        pref.edit().putString(PREF_ACCESS_TOKEN, accessToken).apply()

    override fun getAccessToken(): String =
        pref.getString(PREF_ACCESS_TOKEN, "") ?: ""

    override fun deleteAccessToken() =
        pref.edit().remove(PREF_ACCESS_TOKEN).apply()

    override fun setRefreshToken(refreshToken: String) =
        pref.edit().putString(PREF_REFRESH_TOKEN, refreshToken).apply()

    override fun getRefreshToken(): String =
        pref.getString(PREF_REFRESH_TOKEN, "") ?: ""

    override fun deleteRefreshToken() =
        pref.edit().remove(PREF_REFRESH_TOKEN).apply()

    // Student

    override fun setStudent(student: Student) {
        val studentJsonData = Gson().toJson(student)
        pref.edit().putString(PREF_STUDENT, studentJsonData).apply()
    }

    override fun getStudent(): Student {
        return Gson().fromJson(
            JsonParser().parse(
                pref.getString(PREF_STUDENT, "") ?: ""
            ), Student::class.java
        )
    }

    override fun deleteStudent() {
        pref.edit().remove(PREF_STUDENT).apply()
    }
}