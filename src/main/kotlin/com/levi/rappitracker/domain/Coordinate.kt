package com.levi.rappitracker.domain

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document
import java.io.Serializable
import java.time.Instant
import javax.validation.constraints.NotNull

@Document
data class Coordinate (
        val speed: Double,
        @NotNull val date: Instant,
        @NotNull val deliveryManId: Int,
        @NotNull val latitude : Double,
        @NotNull val longitude : Double,
        @NotNull @Indexed val orderId : String,
        @Id val id: String? = null
) : Serializable
