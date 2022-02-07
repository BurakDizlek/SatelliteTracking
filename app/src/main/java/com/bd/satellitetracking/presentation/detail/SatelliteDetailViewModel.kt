package com.bd.satellitetracking.presentation.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bd.data.model.Position
import com.bd.data.model.SatelliteDetail
import com.bd.satellitetracking.domain.usecase.GetPositionsOfSatelliteUseCase
import com.bd.satellitetracking.domain.usecase.GetSatelliteDetailUseCase
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class SatelliteDetailViewModel(
    private val getSatelliteDetailUseCase: GetSatelliteDetailUseCase,
    private val getPositionsOfSatelliteUseCase: GetPositionsOfSatelliteUseCase
) : ViewModel() {

    private val _detail = MutableLiveData<SatelliteDetail>()
    val detail: LiveData<SatelliteDetail> = _detail

    private val _position = MutableLiveData<Position>()
    val position: LiveData<Position> = _position

    fun getSatelliteDetailById(id: Int) {
        viewModelScope.launch {
            getSatelliteDetailUseCase.invoke(id).collect { detail ->
                _detail.postValue(detail)
            }
        }
    }

    fun getSatellitePositionById(id: Int) {
        viewModelScope.launch {
            getPositionsOfSatelliteUseCase.invoke(id).collect { position ->
                _position.postValue(position)
            }
        }
    }
}