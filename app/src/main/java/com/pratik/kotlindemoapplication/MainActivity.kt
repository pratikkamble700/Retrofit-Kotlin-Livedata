package com.pratik.kotlindemoapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pratik.kotlindemoapplication.adapters.EmployeeAdapter
import com.pratik.kotlindemoapplication.model.EmployeeResponseParser
import com.pratik.kotlindemoapplication.viewmodel.MainActivityViewModel


class MainActivity : AppCompatActivity() {

    var articleArrayList: ArrayList<EmployeeResponseParser> = ArrayList()
    var newsAdapter: EmployeeAdapter? = null
    var rvHeadline: RecyclerView? = null
    var newsViewModel: MainActivityViewModel? = null
    private lateinit var linearLayoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rvHeadline = findViewById(R.id.recyclerView);
        newsViewModel = ViewModelProviders.of(this)[MainActivityViewModel::class.java]

        newsViewModel?.init()
        newsViewModel?.getNewsRepository()?.observe(this, Observer { employeeResponse ->
            articleArrayList.addAll(employeeResponse)
            newsAdapter!!.notifyDataSetChanged()
        })

        setupRecyclerView();
    }

    fun setupRecyclerView() {
        if (newsAdapter == null) {
            newsAdapter = EmployeeAdapter( articleArrayList);
            rvHeadline!!.setLayoutManager(LinearLayoutManager(this));
            rvHeadline!!.setAdapter(newsAdapter);
            rvHeadline!!.setItemAnimator(DefaultItemAnimator());
            rvHeadline!!.setNestedScrollingEnabled(true);
        } else {
            newsAdapter!!.notifyDataSetChanged();
        }
    }
    }
