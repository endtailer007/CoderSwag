package com.example.coderswag.controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView

import com.example.coderswag.R
import com.example.coderswag.adapters.CategoryAdapter
import com.example.coderswag.model.Category
import com.example.coderswag.services.DataService

class MainActivity : AppCompatActivity() {
    lateinit var adapter:CategoryAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        adapter =CategoryAdapter(this,DataService.categories)
        findViewById<ListView>(R.id.categoryListView).adapter=adapter
    }
}