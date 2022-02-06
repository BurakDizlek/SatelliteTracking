package com.bd.satellitetracking.presentation.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bd.data.model.SatelliteDetail
import com.bd.satellitetracking.domain.base.BaseViewState
import com.bd.satellitetracking.domain.usecase.GetSatelliteDetailUseCase
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class SatelliteDetailViewModel(
    private val getSatelliteDetailUseCase: GetSatelliteDetailUseCase
) : ViewModel() {

    private val _satelliteDetail = MutableLiveData<BaseViewState<SatelliteDetail>>()
    val satelliteDetail: LiveData<BaseViewState<SatelliteDetail>> = _satelliteDetail

    fun getSatelliteDetailById(id: Int) {
        _satelliteDetail.postValue(BaseViewState.Loading)
        viewModelScope.launch {
            try {
                getSatelliteDetailUseCase.invoke(id).collect { detail ->
                    _satelliteDetail.postValue(BaseViewState.Success(data = detail))
                }
            } catch (e: Throwable) {
                _satelliteDetail.postValue(BaseViewState.Error(message = e.message.orEmpty()))
            }
        }
    }
}