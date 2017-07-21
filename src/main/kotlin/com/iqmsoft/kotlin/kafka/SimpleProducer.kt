package com.iqmsoft.kotlin.kafka

import org.apache.kafka.clients.producer.KafkaProducer
import org.apache.kafka.clients.producer.ProducerRecord
import org.apache.kafka.common.serialization.StringSerializer
import org.slf4j.LoggerFactory


class SimpleProducer {

    private val log = loggerFor(javaClass)

    fun run() {
        val properties = ApplicationConfig().getProperties()
        val producer = KafkaProducer<String, String>(properties, StringSerializer(), StringSerializer())
        producer.send(ProducerRecord(properties.getProperty("topic"), "exampleKey1", "exampleValue1"))
        producer.send(ProducerRecord(properties.getProperty("topic"), "exampleKey2", "exampleValue2"))
        producer.send(ProducerRecord(properties.getProperty("topic"), "exampleKey3", "exampleValue3"))
        producer.send(ProducerRecord(properties.getProperty("topic"), "exampleKey4", "exampleValue4"))
        producer.send(ProducerRecord(properties.getProperty("topic"), "exampleKey5", "exampleValue5"))        
        producer.close()
        log.info("Message sent successfully")
    }

    fun <T> loggerFor(clazz: Class<T>) = LoggerFactory.getLogger(clazz)
}
