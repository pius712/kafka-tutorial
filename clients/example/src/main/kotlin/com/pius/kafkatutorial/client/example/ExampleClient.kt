package com.pius.kafkatutorial.client.example

import com.pius.kafkatutorial.client.example.model.response.ExampleResponse
import org.springframework.stereotype.Component

@Component
class ExampleClient internal constructor(
    private val exampleApi: ExampleApi
) {

    fun getExample(): ExampleResponse {
        val result = exampleApi.getExample(1)
        return ExampleResponse(result)
    }
}