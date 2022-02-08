package com.bd.satellitetracking.domain.usecase

import com.bd.data.model.Satellite
import com.bd.satellitetracking.datasource.SatelliteRepositoryImp
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.mockk
import io.mockk.unmockkAll
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.After
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class GetSatelliteListUseCaseTest {

    private val mockSatelliteRepository =
        SatelliteRepositoryImp(mockk(relaxed = true), mockk(relaxed = true))

    private val mockList = listOf(
        Satellite(id = 1, active = false, name = "Satellite1"),
        Satellite(id = 2, active = true, name = "Satellite2"),
        Satellite(id = 3, active = true, name = "Satellite3")
    )

    @Before
    fun setUp() {
        MockKAnnotations.init(this, relaxUnitFun = true)
        coEvery { mockSatelliteRepository.getSatelliteList() } coAnswers { mockList }
    }

    @After
    fun tearDown() {
        unmockkAll()
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `get satellite list is not empty `() {
        runBlockingTest {
            val list = mockSatelliteRepository.getSatelliteList()
            assert(list.isNotEmpty())
        }
    }
}