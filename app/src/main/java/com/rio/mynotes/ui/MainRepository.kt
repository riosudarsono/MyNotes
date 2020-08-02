package com.rio.mynotes.ui

import androidx.lifecycle.MutableLiveData
import com.rio.mynotes.data.ApiService
import com.rio.mynotes.data.response.BaseResponse
import com.rio.mynotes.data.response.DataModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainRepository {
    private val apiService = ApiService().retrofit
    private val compositeDisposable = CompositeDisposable()
    private var loading: MutableLiveData<Boolean> = MutableLiveData()

    fun getData(id:String): MutableLiveData<BaseResponse<List<DataModel>>>{
        var data: MutableLiveData<BaseResponse<List<DataModel>>> = MutableLiveData()
        loading.value = true

        compositeDisposable.add( apiService.searchMovie("1","","")
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.newThread())
            .subscribe({response ->
                data.value = response
                loading.value = false
            },{t ->
                loading.value = false
            }))
        return data
    }

    fun getLoading(): MutableLiveData<Boolean>{
        return loading
    }

    fun onDestroy(){
        compositeDisposable.dispose()
    }
}