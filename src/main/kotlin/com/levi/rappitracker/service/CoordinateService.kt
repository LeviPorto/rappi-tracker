package com.levi.rappitracker.service

import com.levi.rappitracker.domain.Coordinate
import com.levi.rappitracker.publisher.CoordinatePublisher
import com.levi.rappitracker.repository.CoordinateRepository
import org.springframework.stereotype.Service

@Service
class CoordinateService(val repository: CoordinateRepository, val publisher : CoordinatePublisher) {

    fun create(coordinate: Coordinate) : Coordinate {
        val savedCoordinate = repository.save(coordinate)
        publisher.sendCoordinateToTopic(savedCoordinate)
        return savedCoordinate
    }

}
