package com.github.tonybaines.kafka

import org.apache.kafka.clients.consumer.KafkaConsumer
import org.apache.kafka.common.serialization.StringDeserializer
import java.time.Duration
import java.util.*

object SimpleConsumer {

    @JvmStatic
    fun main(args: Array<String>) {
        val consumer = createConsumer("127.0.0.1:9092")

        consumer.subscribe(listOf("tony_test1"))
        while(true) {
            val records = consumer.poll(Duration.ofSeconds(2))
            records.iterator().forEach { println(it.value()) }
        }
    }

    private fun createConsumer(brokers: String): KafkaConsumer<String, String> {
        val props = Properties()
        props["bootstrap.servers"] = brokers
        props["group.id"] = "simple-processor"
        props["key.deserializer"] = StringDeserializer::class.java
        props["value.deserializer"] = StringDeserializer::class.java
        return KafkaConsumer<String, String>(props)
    }
}