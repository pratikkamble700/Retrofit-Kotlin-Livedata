package com.pratik.kotlindemoapplication.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class ApiClient {
    companion object {
        val retrofit = Retrofit.Builder()
            .baseUrl("http://dummy.restapiexample.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        @JvmStatic
        fun <S> cteateService(serviceClass: Class<S>?): S {
            return retrofit.create(serviceClass)
        }

    }
}