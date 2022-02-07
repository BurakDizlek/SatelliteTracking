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
import java.text.NumberFormat
import java.util.*

class SatelliteDetailViewModel(
    private val getSatelliteDetailUseCase: GetSatelliteDetailUseCase,
    private val getPositionsOfSatelliteUseCase: GetPositionsOfSatelliteUseCase
) : ViewModel() {

    private val nf = NumberFormat.getNumberInstance(Locale.GERMANY) //6.000.000

    private val _detail = MutableLiveData<SatelliteDetail>()
    val detail: LiveData<SatelliteDetail> = _detail

    private val _position = MutableLiveData<Position>()
    val position: LiveData<Position> = _position

    private val _title = MutableLiveData<String>()
    val title: LiveData<String> = _title

    private val _formattedCostText = MutableLiveData<String>()
    val formattedCostText: LiveData<String> = _formattedCostText

    fun getSatelliteDetailById(id: Int) {
        viewModelScope.launch {
            getSatelliteDetailUseCase.invoke(id).collect { detail ->
                _detail.postValue(detail)
                _formattedCostText.postValue(nf.format(detail.costPerLaunch))
            }
        }
    }

    fun getSatellitePositionById(id: Int) {
        viewModelScope.launch {
            getPositionsOfSatelliteUseCase.invoke(id).collect { position ->
                _position.value = position
            }
        }
    }

    fun setTitle(title: String) {
        _title.postValue(title)
    }
}