package com.bd.satellitetracking.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> = _loading


    fun showLoading() {
        if (_loading.value != true) {
            _loading.postValue(true)
        }
    }

    fun hideLoading() {
        if (_loading.value == true) {
            _loading.postValue(false)
        }
    }
}