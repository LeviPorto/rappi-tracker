package com.levi.rappitracker.controller

import com.levi.rappitracker.domain.Coordinate
import com.levi.rappitracker.service.CoordinateService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/tracker/coordinate")
class CoordinateController(val service: CoordinateService) {

    @PostMapping
    fun create(@RequestBody coordinate: Coordinate) : Coordinate {
        return service.create(coordinate)
    }

    @GetMapping("/order/{orderId}")
    fun findByOrder(@PathVariable orderId : String) : List<Coordinate> {
        return service.retrieveByOrder(orderId)
    }

}
