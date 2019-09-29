package com.levi.rappitracker.repository

import com.levi.rappitracker.domain.Coordinate
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface CoordinateRepository : MongoRepository<Coordinate, String> {

    fun findByOrderId(orderId : String) : List<Coordinate>

}
