package com.levi.rappitracker.service

import com.levi.rappitracker.domain.Coordinate
import com.levi.rappitracker.publisher.CoordinatePublisher
import com.levi.rappitracker.repository.CoordinateRepository
import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.Cacheable
import org.springframework.cache.annotation.Caching
import org.springframework.stereotype.Service

@Service
class CoordinateService(val repository: CoordinateRepository, val publisher : CoordinatePublisher) {


    @Caching(evict = [CacheEvict(value = ["COORDINATES_BY_ORDER_ID_"], key = "{#coordinate.orderId}")])
    fun create(coordinate: Coordinate) : Coordinate {
        val savedCoordinate = repository.save(coordinate)
        publisher.sendCoordinateToTopic(savedCoordinate)
        return savedCoordinate
    }

    @Cacheable(value = ["COORDINATES_BY_ORDER_ID_"], key = "{#orderId}", unless = "#result == null || #result.isEmpty()")
    fun retrieveByOrder(orderId : String) : List<Coordinate> {
        return repository.findByOrderId(orderId)
    }

}
