package com.dsm.cms.error

import com.dsm.cms.error.exception.*
import retrofit2.HttpException
import java.net.HttpURLConnection

class ErrorHandlerImpl : ErrorHandler {
    override fun getNetworkException(throwable: Throwable) =
        when (throwable) {
            is HttpException -> {
                when (throwable.code()) {
                    HttpURLConnection.HTTP_UNAUTHORIZED -> UnauthorizedException(throwable)

                    HttpURLConnection.HTTP_FORBIDDEN -> ForbiddenException(throwable)

                    HttpURLConnection.HTTP_NOT_FOUND -> NotFoundException(throwable)

                    HttpURLConnection.HTTP_CONFLICT -> ConflictException(throwable)

                    HttpURLConnection.HTTP_BAD_REQUEST -> BadRequestException(throwable)

                    else -> InternalException(throwable)
                }
            }

            else -> InternalException(throwable)
        }

}