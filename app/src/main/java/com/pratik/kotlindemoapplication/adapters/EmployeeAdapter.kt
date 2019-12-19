package com.pratik.kotlindemoapplication.adapters

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.pratik.kotlindemoapplication.R
import com.pratik.kotlindemoapplication.inflate
import com.pratik.kotlindemoapplication.model.EmployeeResponseParser
import kotlinx.android.synthetic.main.item_employee.view.*

class EmployeeAdapter(val employees: ArrayList<EmployeeResponseParser>) :
    RecyclerView.Adapter<EmployeeAdapter.PhotoHolder>() {


    class PhotoHolder(v: View) : RecyclerView.ViewHolder(v), View.OnClickListener {
        //2
        private var view: View = v
        private var employee: EmployeeResponseParser? = null

        //3
        init {
            v.setOnClickListener(this)
        }

        //4
        override fun onClick(v: View) {
            Log.d("RecyclerView", "CLICK!")
            /*  val context = itemView.context
              val showPhotoIntent = Intent(context, PhotoActivity::class.java)
              showPhotoIntent.putExtra(PHOTO_KEY, photo)
              context.startActivity(showPhotoIntent)*/
        }

        companion object {
            //5
            private val PHOTO_KEY = "PHOTO"
        }

        fun bindEmployee(employee: EmployeeResponseParser) {
            this.employee = employee
//            Picasso.get().load(employee.profileImage).into(view.itemImage)
            Glide.with(itemView.context).load("https://via.placeholder.com/300.png/09f/fff"/*employee.profileImage*/).into(view.itemImage)
            view.itemDate.text = employee.employeeName
            view.itemDescription.text = employee.employeeSalary
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeeAdapter.PhotoHolder {
        val inflatedView = parent.inflate(R.layout.item_employee, false)
        return PhotoHolder(inflatedView)
    }


    override fun getItemCount(): Int = employees.size

    override fun onBindViewHolder(holder: PhotoHolder, position: Int) {
        val itemPhoto = employees[position]
        holder.bindEmployee(itemPhoto)
    }


}