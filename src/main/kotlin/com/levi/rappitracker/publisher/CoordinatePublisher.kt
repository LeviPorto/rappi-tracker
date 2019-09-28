package com.levi.rappitracker.publisher

import com.levi.rappitracker.domain.Coordinate
import org.springframework.beans.factory.annotation.Value
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.support.KafkaHeaders
import org.springframework.messaging.support.MessageBuilder
import org.springframework.stereotype.Component
import java.text.ParseException

@Component
class CoordinatePublisher(private val kafkaTemplate: KafkaTemplate<String, Coordinate>) {

    @Value("\${spring.kafka.topic.coordinate}")
    var topicCoordinate: String? = null

    @Throws(ParseException::class)
    fun sendCoordinateToTopic(coordinate : Coordinate) {
        val message = MessageBuilder
                .withPayload(coordinate)
                .setHeader(KafkaHeaders.TOPIC, topicCoordinate)
                .build()
        kafkaTemplate.send(message)
    }

}

