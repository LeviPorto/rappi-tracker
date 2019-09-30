package com.levi.rappitracker.dto

data class CoordinateDTO (
        val speed: Double,
        val deliveryManId: Int,
        val latitude : Double,
        val longitude : Double,
        val orderId : String
)
