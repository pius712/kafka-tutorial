package com.pius.kafkatutorial.core.application

import org.slf4j.LoggerFactory
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service

@Service
class TestService(
    private val kafkaTemplate: KafkaTemplate<String, Test>,
) {

    val log = LoggerFactory.getLogger(javaClass)

    // send 의 리턴 타입은 Completable Future 이다.
    // whenComplete 를 통해 비동기 작업이 완료되었을 때 처리를 할 수 있다.
    fun produce() {
        // 바로 전송되는게 아님.
        kafkaTemplate.send("topic", Test(1, "test"))

    }

}