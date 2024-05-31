package com.pius.kafkatutorial.config

import org.apache.kafka.clients.consumer.ConsumerConfig
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory
import org.springframework.kafka.core.ConsumerFactory
import org.springframework.kafka.core.DefaultKafkaConsumerFactory
import org.springframework.kafka.listener.ContainerProperties

@Configuration
class KafkaConsumerConfig {

    @Bean
    fun consumerFactory(): ConsumerFactory<String, String> {
        val config: MutableMap<String, Any> = HashMap()
        // 필수 설정
        config[ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG] = "localhost:9092"
        config[ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG] = String::class.java
        config[ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG] = String::class.java
        // subscribe 하는 경우, 필요함.
        // 컨슘 하는 순간 그룹이 생김
        config[ConsumerConfig.GROUP_ID_CONFIG] = "consumer-group"

        // 선택 설정
        config[ConsumerConfig.AUTO_OFFSET_RESET_CONFIG] = "latest" // default
        return DefaultKafkaConsumerFactory(config)
    }

    @Bean
    fun listenerContainerFactory(): ConcurrentKafkaListenerContainerFactory<String, String> {
        val factory = ConcurrentKafkaListenerContainerFactory<String, String>()
        factory.containerProperties.ackMode = ContainerProperties.AckMode.MANUAL

        return factory
    }
}