package com.pius.kafkatutorial.controller.v1

import com.pius.kafkatutorial.controller.v1.response.MemberResponseDto
import com.pius.kafkatutorial.core.application.TestService
import com.pius.kafkatutorial.support.response.ApiResponse
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/member")
class TestController(
    private val testService: TestService
) {


    @PostMapping("/create")
    fun create(): Long {
        return testService.produce()
    }

    @GetMapping("/{memberId}")
    fun getMember(
        @PathVariable memberId: Long
    ): ApiResponse<MemberResponseDto> {
        val member = testService.find(memberId)
        return ApiResponse.ok(MemberResponseDto(member.name))
    }
}