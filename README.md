# RAPPI-TRACKER

## Motivation

To isolate all entities that is important to make track each order, rappi-tracker was 
created. Considering coordinates requests (save and find it) has many requests
(each order send, each minute, coordinates) i saw necessity of create that micro-service,
because of the quantity that requests (we can scale horizontally, creating many 
instances of it). Also, this micro-service uses NO-SQL database to find faster the 
information, instead of has more trustworthy data. This micro-service is small, but
i think is better separate just because of demand requests and isolate database domain

# Domain

There is just one entity: Coordinate. That entity contains information of who sent
coordinate, where and when did it. Is important to track order, basically.

# Architecture and Technologies

rappi-tracker is a micro-service, that is discovered by Eureka, to communicate with 
others micro-services. Made in Kotlin, using functional programming to clean code and 
make more predictable, feign to communicate with others micro-services, kafka to produce
messages, redis to cache, mongo to store data. This micro-service uses event-driven 
pattern to communicate with others micro-services

# Flux

Base end point is {host}/tracker/. To test, we considering localhost.
 
* We can send POST on /coordinate, passing coordinate entity, in a body (see a code) - Create Coordinate, sending
coordinate was created message in kafka
* We can find by order, send GET coordinate/order/{orderId}.

This, together with deliverer, implements a functionality that complete delivery automatically, based 
only on coordinates and status of it.


# Dependencies

* RAPPI-EUREKA
* RAPPI-CONFIG
* RAPPI-MANAGER
* RAPPI-DELIVERER
* Redis
* Kafka
* Mongo
