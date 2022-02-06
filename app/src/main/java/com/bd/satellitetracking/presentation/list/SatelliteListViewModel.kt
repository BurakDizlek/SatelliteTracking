package com.bd.satellitetracking.presentation.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bd.data.model.Satellite
import com.bd.satellitetracking.domain.base.BaseViewState
import com.bd.satellitetracking.domain.usecase.GetSatelliteListUseCase
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class SatelliteListViewModel(
    private val getSatelliteListUseCase: GetSatelliteListUseCase
) : ViewModel() {

    private val _satelliteList = MutableLiveData<BaseViewState<List<Satellite>>>()
    val satelliteList: LiveData<BaseViewState<List<Satellite>>> = _satelliteList

    fun getSatelliteList() {
        _satelliteList.postValue(BaseViewState.Loading)
        viewModelScope.launch {
            try {
                getSatelliteListUseCase.invoke().collect { list ->
                    if (list.isNotEmpty()) {
                        _satelliteList.postValue(BaseViewState.Success(data = list))
                    } else {
                        _satelliteList.postValue(BaseViewState.NoData("There is no data."))
                    }
                }
            } catch (e: Throwable) {
                _satelliteList.postValue(BaseViewState.Error(message = e.message.orEmpty()))
            }
        }
    }
}