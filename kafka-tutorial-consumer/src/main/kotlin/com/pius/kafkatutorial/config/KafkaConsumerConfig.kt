package com.pius.kafkatutorial.config

import org.apache.kafka.clients.consumer.ConsumerConfig
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.core.ConsumerFactory
import org.springframework.kafka.core.DefaultKafkaConsumerFactory

@Configuration
class KafkaConsumerConfig {

    @Bean
    fun consumerFactory(): ConsumerFactory<String, String> {
        val config: MutableMap<String, Any> = HashMap()
        // 필수 설정
        config[ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG] = "localhost:9092"
        config[ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG] = String::class.java
        config[ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG] = String::class.java
        // 이건 사실상 필수인듯?
        config[ConsumerConfig.GROUP_ID_CONFIG] = "consumer-group"
        // 선택 설정


        return DefaultKafkaConsumerFactory(config)
    }

}