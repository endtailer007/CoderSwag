package com.example.coderswag.controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.example.coderswag.R
import com.example.coderswag.adapters.CategoryAdapter
import com.example.coderswag.adapters.CategoryRecycleAdapter
import com.example.coderswag.model.Category
import com.example.coderswag.services.DataService

class MainActivity : AppCompatActivity() {
    lateinit var adapter:CategoryRecycleAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        adapter = CategoryRecycleAdapter(this,DataService.categories)
        findViewById<RecyclerView>(R.id.categoryListView).adapter=adapter
        val layoutManager=LinearLayoutManager(this)
        findViewById<RecyclerView>(R.id.categoryListView).layoutManager=layoutManager
        findViewById<RecyclerView>(R.id.categoryListView).setHasFixedSize(true)


    }
}