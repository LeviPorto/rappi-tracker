package com.levi.rappitracker.controller

import com.levi.rappitracker.domain.Coordinate
import com.levi.rappitracker.service.CoordinateService
import org.springframework.web.bind.annotation.*

//TODO por redis

@RestController
@RequestMapping("/tracker/coordinate")
class CoordinateController(val service: CoordinateService) {

    @PostMapping
    fun create(@RequestBody coordinate: Coordinate) : Coordinate {
        return service.create(coordinate)
    }

    @GetMapping("/orderId/{orderId}")
    fun findByOrder(@PathVariable orderId : String) : List<Coordinate> {
        return service.retrieveByOrder(orderId)
    }

}
