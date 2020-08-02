package com.rio.mynotes.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.rio.mynotes.data.response.BaseResponse
import com.rio.mynotes.data.response.DataModel

class MainViewModel: ViewModel() {
    private val repository = MainRepository()

    fun getData(id: String) : LiveData<BaseResponse<List<DataModel>>>{
        return repository.getData(id)
    }

    fun getLoading(): LiveData<Boolean>{
        return repository.getLoading()
    }

    override fun onCleared() {
        repository.onDestroy()
        super.onCleared()
    }
}