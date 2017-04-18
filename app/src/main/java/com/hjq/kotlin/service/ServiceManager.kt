package com.hjq.kotlin.service

import com.facebook.stetho.okhttp3.StethoInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by hjq on 17-4-18.
 */
class ServiceManager {
    companion object{
        val API_URL = "http://gank.io/api/"
        val api : ApiService
        init {
            val budler = OkHttpClient.Builder()
            var click = budler.addNetworkInterceptor(StethoInterceptor()).build()
            val retrofit = Retrofit.Builder()
                    .baseUrl(API_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .client(click)
                    .build()
            api = retrofit.create(ApiService::class.java)
        }
    }
}

