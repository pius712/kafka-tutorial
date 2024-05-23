package com.pius.kafkatutorial.support.error

open class BaseException(
    val exceptionType: ErrorType,
    val data: Any?
) : RuntimeException() {
}