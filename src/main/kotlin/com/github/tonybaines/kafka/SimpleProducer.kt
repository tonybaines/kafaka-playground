package com.github.tonybaines.kafka

import org.apache.kafka.clients.producer.KafkaProducer
import org.apache.kafka.clients.producer.Producer
import org.apache.kafka.clients.producer.ProducerRecord
import org.apache.kafka.common.serialization.StringSerializer
import java.util.*

object SimpleProducer {
    private fun createProducer(brokers: String): Producer<String, String> {
        val props = Properties()
        props["bootstrap.servers"] = brokers
        props["key.serializer"] = StringSerializer::class.java
        props["value.serializer"] = StringSerializer::class.java
        return KafkaProducer<String, String>(props)
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val producer = createProducer("127.0.0.1:9092")

        (1..1000).forEach{producer.send(ProducerRecord("tony_test1", it.toString()))}
    }
}