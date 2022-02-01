package com.berkt.cryptocurrencyapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.berkt.cryptocurrencyapp.model.Crypto
import com.berkt.cryptocurrencyapp.network.CryptoService
import com.berkt.cryptocurrencyapp.network.CryptoInstance
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers

class CryptoViewModel: ViewModel() {
    // Live Data
    var cryptoDataList = MutableLiveData<List<Crypto>>()

    private var compositeDisposable: CompositeDisposable? = null

    fun getApiData() {

        compositeDisposable = CompositeDisposable()

        val service = CryptoInstance.getCryptoInstance()
            .create(CryptoService::class.java)

        // RXJava
        compositeDisposable?.add(service.getData()
            // subscribe on data in the background without blocking the main thread
            .subscribeOn(Schedulers.io())
            // observe on data in main thread
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(this::handleResponse))
    }

    fun clearComposite() {
        compositeDisposable?.clear()
    }

    private fun handleResponse(cryptoList: List<Crypto>) {
        cryptoDataList.value = ArrayList(cryptoList)
    }



}