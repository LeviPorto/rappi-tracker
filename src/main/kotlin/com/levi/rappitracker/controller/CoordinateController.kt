package com.levi.rappitracker.controller

import com.levi.rappitracker.domain.Coordinate
import com.levi.rappitracker.service.CoordinateService
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/tracker/coordinate")
class CoordinateController(val service: CoordinateService) {

    fun create(coordinate: Coordinate) : Coordinate {
        return service.create(coordinate)
    }

}
