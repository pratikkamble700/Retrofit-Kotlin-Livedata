package com.pratik.kotlindemoapplication.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pratik.kotlindemoapplication.model.EmployeeResponseParser
import com.pratik.kotlindemoapplication.model.EmployeesRepository


class MainActivityViewModel : ViewModel() {
    var mutableLiveData: MutableLiveData<List<EmployeeResponseParser>>? = null
    var newsRepository: EmployeesRepository? = null

    /*private val users: MutableLiveData<List<EmployeeResponseParser>> by lazy {
        MutableLiveData().also {
            loadUsers()
        }
    }

    fun getUsers(): LiveData<List<EmployeeResponseParser>> {
        return users
    }

    private fun loadUsers() {
        // Do an asynchronous operation to fetch users.
        if (users != null) {
            return
        }
        newsRepository = EmployeesRepository.instance
        newsRepository!!.employeeDetails
    }*/

    fun init() {
        if (mutableLiveData != null) {
            return
        }
        newsRepository = EmployeesRepository.instance
        mutableLiveData = newsRepository!!.employeeDetails
    }

    fun getNewsRepository(): LiveData<List<EmployeeResponseParser>>? {
        return mutableLiveData
    }

}