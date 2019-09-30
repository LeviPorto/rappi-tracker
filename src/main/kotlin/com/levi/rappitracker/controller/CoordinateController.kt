package com.levi.rappitracker.controller

import com.levi.rappitracker.domain.Coordinate
import com.levi.rappitracker.service.CoordinateService
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/tracker/coordinate")
class CoordinateController(val service: CoordinateService) {

    @PostMapping
    fun create(@Valid @RequestBody coordinate: Coordinate) : Coordinate = service.create(coordinate)


    @GetMapping("/order/{orderId}")
    fun findByOrder(@PathVariable orderId : String) : List<Coordinate> = service.retrieveByOrder(orderId)


}
