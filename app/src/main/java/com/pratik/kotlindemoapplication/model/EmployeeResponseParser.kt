package com.pratik.kotlindemoapplication.model

import android.annotation.SuppressLint
import android.os.Parcelable
import androidx.annotation.Nullable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@SuppressLint
@Parcelize
data class EmployeeResponseParser(
    @SerializedName("id")
    @Expose
    val id: String,
    @SerializedName("employee_name")
    @Expose
    val employeeName: String,
    @SerializedName("employee_salary")
    @Expose
    val employeeSalary: String,
    @SerializedName("employee_age")
    @Expose
    val employeeAge: String,
    @SerializedName("profile_image")
    @Expose
    val profileImage: String? = null
) : Parcelable