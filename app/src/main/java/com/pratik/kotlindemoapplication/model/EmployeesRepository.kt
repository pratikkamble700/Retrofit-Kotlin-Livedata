package com.pratik.kotlindemoapplication.model

import androidx.lifecycle.MutableLiveData
import com.pratik.kotlindemoapplication.network.ApiClient.Companion.cteateService
import com.pratik.kotlindemoapplication.network.ApiInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EmployeesRepository {
    private val newsApi: ApiInterface
    val employeeDetails: MutableLiveData<List<EmployeeResponseParser>>
        get() {
            val newsData =
                MutableLiveData<List<EmployeeResponseParser>>()
            newsApi.getEmployeesList()
                .enqueue(object : Callback<List<EmployeeResponseParser>> {
                    override fun onResponse(
                        call: Call<List<EmployeeResponseParser>>,
                        response: Response<List<EmployeeResponseParser>>
                    ) {
                        if (response.isSuccessful) {
                            newsData.value = response.body()
                        }
                    }

                    override fun onFailure(
                        call: Call<List<EmployeeResponseParser>>,
                        t: Throwable
                    ) {
                        newsData.value = null
                    }
                })
            return newsData
        }

    companion object {
        private var newsRepository: EmployeesRepository? = null
        val instance: EmployeesRepository?
            get() {
                if (newsRepository == null) {
                    newsRepository = EmployeesRepository()
                }
                return newsRepository
            }
    }

    init {
        newsApi = cteateService(ApiInterface::class.java)
    }
}