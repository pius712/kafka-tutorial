package com.pius.kafkatutorial.config

import org.springframework.kafka.annotation.KafkaListener
import org.springframework.kafka.support.Acknowledgment
import org.springframework.stereotype.Component

@Component
class TestConsumer {

    @KafkaListener(topics = ["test"], groupId = "group_1")
    fun listen(userId: Long, acknowledgment: Acknowledgment) {
        println("Received Message: $userId")
        acknowledgment.acknowledge()
    }
}