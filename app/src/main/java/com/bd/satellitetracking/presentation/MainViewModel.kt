package com.bd.satellitetracking.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private val _loading = MutableLiveData<Boolean>() //todo loading view will be implemented.
    val loading: LiveData<Boolean> = _loading


}