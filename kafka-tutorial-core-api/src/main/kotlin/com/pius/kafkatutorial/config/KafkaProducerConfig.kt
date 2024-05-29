package com.pius.kafkatutorial.config

import com.pius.kafkatutorial.core.application.Test
import org.apache.kafka.clients.producer.ProducerConfig
import org.apache.kafka.common.serialization.StringSerializer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.core.DefaultKafkaProducerFactory
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.core.ProducerFactory
import org.springframework.kafka.support.serializer.JsonSerializer

@Configuration
class KafkaProducerConfig {

    @Bean
    fun testProducerFactory(): ProducerFactory<String, Test> {
        val config: MutableMap<String, Any> = getProducerConfigs()


        return DefaultKafkaProducerFactory(config)
    }

    @Bean
    fun kafkaTemplate(): KafkaTemplate<String, Test> {
        return KafkaTemplate(testProducerFactory())
    }

    private fun getProducerConfigs(): MutableMap<String, Any> {
        val config: MutableMap<String, Any> = HashMap()
        // 필수 설정
        config[ProducerConfig.BOOTSTRAP_SERVERS_CONFIG] = "localhost:9092"
        config[ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG] = StringSerializer::class.java
        config[ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG] = JsonSerializer::class.java

        // 선택 설정
        config[ProducerConfig.ACKS_CONFIG] = "all"
        config[ProducerConfig.RETRIES_CONFIG] = 3
        config[ProducerConfig.BATCH_SIZE_CONFIG] = 16384
        config[ProducerConfig.LINGER_MS_CONFIG] = 1
        config[ProducerConfig.BUFFER_MEMORY_CONFIG] = 33554432
        return config
    }
}