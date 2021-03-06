package com.dsm.cms.data.interceptor

import com.dsm.cms.data.api.TokenApi
import com.dsm.cms.data.pref.PrefStorage
import okhttp3.Interceptor
import okhttp3.Response
import java.net.HttpURLConnection

class TokenInterceptor (
    private val prefStorage: PrefStorage,
    private val tokenApi: TokenApi
) : Interceptor {

    companion object {
        private const val strAccessToken = "X-Access-Token"
    }

    override fun intercept(chain: Interceptor.Chain): Response {
        val accessToken = prefStorage.getAccessToken()
        val refreshToken = prefStorage.getRefreshToken()

        val request = chain.request().newBuilder().run {
            removeHeader(strAccessToken)
            addHeader(strAccessToken, accessToken)
            build()
        }

        val response = chain.proceed(request)

        return if (response.code == HttpURLConnection.HTTP_FORBIDDEN) {
            val refreshResponse = tokenApi.refreshToken(refreshToken).execute()

            if (refreshResponse.code() == HttpURLConnection.HTTP_OK) {
                val newToken = refreshResponse.body()?.get("accessToken") ?: ""
                prefStorage.setAccessToken(newToken)

                response.close()
                chain.proceed(
                    request.newBuilder().run {
                        removeHeader(strAccessToken)
                        addHeader(strAccessToken, newToken)
                        build()
                    }
                )
            } else {
                prefStorage.deleteAccessToken()
                prefStorage.deleteRefreshToken()
                prefStorage.deleteStudent()
                response
            }
        } else {
            response
        }
    }
}