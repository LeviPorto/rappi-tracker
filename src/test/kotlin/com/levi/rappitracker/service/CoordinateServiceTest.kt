package com.levi.rappitracker.service

import com.levi.rappitracker.RappiTrackerApplication
import com.levi.rappitracker.domain.Coordinate
import com.levi.rappitracker.publisher.CoordinatePublisher
import com.levi.rappitracker.repository.CoordinateRepository
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.BDDMockito
import org.mockito.Mock
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.junit4.SpringRunner
import java.time.Instant

@RunWith(SpringRunner::class)
@SpringBootTest(classes = [RappiTrackerApplication::class])
@ActiveProfiles("test")
class CoordinateServiceTest {

    @Autowired
    private val service : CoordinateService? = null

    @Mock
    private val repository : CoordinateRepository? = null

    @Mock
    private val publisher : CoordinatePublisher? = null

    companion object {
        private val INSTANT: Instant = Instant.now()

        private const val COORDINATE_SPEED = 20.0
        private const val COORDINATE_DELIVERY_MAN_ID = 1
        private const val COORDINATE_LATITUDE = 10.123
        private const val COORDINATE_LONGITUDE = 10.313
        private const val COORDINATE_ORDER_ID = "fefeffefaef2232"
        private const val COORDINATE_ID_1 = "ni4n5i4ni22n5n55"
        private const val COORDINATE_ID_2 = "ni4n5i4nfr2n5n55"

        private const val ORDER_ID = "effefeeeggrgr"
    }

    @Test
    fun create() {
        BDDMockito.given(repository!!.save(Mockito.any(Coordinate::class.java))).willReturn(givenCoordinate())
        val createdCoordinate = service!!.create(givenCoordinate())
        Assert.assertNotNull(createdCoordinate)
    }

    @Test
    fun retrieveByOrder() {
        BDDMockito.given(repository!!.findByOrderId(ORDER_ID)).willReturn(givenCoordinates())
        val coordinatesByOrder = service!!.retrieveByOrder(ORDER_ID)
        Assert.assertNotNull(coordinatesByOrder)
    }

    private fun givenCoordinate() : Coordinate = Coordinate(COORDINATE_SPEED, INSTANT, COORDINATE_DELIVERY_MAN_ID,
            COORDINATE_LATITUDE, COORDINATE_LONGITUDE, COORDINATE_ORDER_ID, COORDINATE_ID_1)

    private fun givenCoordinates() : List<Coordinate> = listOf(Coordinate(COORDINATE_SPEED, INSTANT, COORDINATE_DELIVERY_MAN_ID,
            COORDINATE_LATITUDE, COORDINATE_LONGITUDE, COORDINATE_ORDER_ID, COORDINATE_ID_1), Coordinate(COORDINATE_SPEED, INSTANT, COORDINATE_DELIVERY_MAN_ID,
            COORDINATE_LATITUDE, COORDINATE_LONGITUDE, COORDINATE_ORDER_ID, COORDINATE_ID_2))

}
