package com.pratik.kotlindemoapplication.network

import androidx.lifecycle.MutableLiveData
import com.pratik.kotlindemoapplication.model.EmployeeResponseParser
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("api/v1/employees")
    fun getEmployeesList(): Call<List<EmployeeResponseParser>>

}