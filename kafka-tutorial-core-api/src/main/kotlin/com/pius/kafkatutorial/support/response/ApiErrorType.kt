package com.pius.kafkatutorial.support.response

import com.pius.kafkatutorial.support.error.ErrorCode

data class ApiErrorType(
    val code: ErrorCode,
    val message: String
)
