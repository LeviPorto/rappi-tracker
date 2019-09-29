package com.levi.rappitracker.domain

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document
import java.time.Instant

@Document
data class Coordinate (
        val speed: Double,
        val date: Instant,
        val deliveryManId: Int,
        val latitude : Double,
        val longitude : Double,
        @Indexed val orderId : String,
        @Id val id: String? = null
)
