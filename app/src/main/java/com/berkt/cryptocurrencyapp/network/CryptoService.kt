package com.berkt.cryptocurrencyapp.network

import com.berkt.cryptocurrencyapp.model.CryptoData
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET

interface CryptoService {

    @GET("/atilsamancioglu/K21-JSONDataSet/master/crypto.json")
    fun getData(): Observable<List<CryptoData>>

    //fun getData(): Call<List<CryptoData>>

}