package com.pius.kafkatutorial.support.error

class CoreApiException(
    exceptionType: ErrorType, data: Any?
) : BaseException(exceptionType, data)