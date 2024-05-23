package com.pius.kafkatutorial.support.error

import org.springframework.boot.logging.LogLevel
import org.springframework.http.HttpStatus

interface ErrorType {
    val status: HttpStatus
    val errorCode: ErrorCode
    val message: String
    val logLevel: LogLevel
}
