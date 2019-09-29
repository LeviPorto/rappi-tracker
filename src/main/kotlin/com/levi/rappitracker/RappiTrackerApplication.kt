package com.levi.rappitracker

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching

@SpringBootApplication
@EnableCaching
class RappiTrackerApplication

fun main(args: Array<String>) {
    runApplication<RappiTrackerApplication>(*args)
}
