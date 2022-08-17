package com.example.coderswag.controller

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.coderswag.R
import com.example.coderswag.adapters.ProductsAdapter
import com.example.coderswag.services.DataService
import com.example.coderswag.utilities.EXTRA_CATEGORY

class ProductsActivity : AppCompatActivity() {
    lateinit var adapter:ProductsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)
        val categoryType=intent.getStringExtra(EXTRA_CATEGORY)
        adapter= ProductsAdapter(this,DataService.getProducts(categoryType.toString()))
        var spancount=2
        val orientation=resources.configuration.orientation
        if (orientation==Configuration.ORIENTATION_LANDSCAPE){
            spancount=3
        }
        val screensize=resources.configuration.screenWidthDp
        if (screensize>720){
            spancount=3
        }
        val layoutManager=GridLayoutManager(this,spancount)
        findViewById<RecyclerView>(R.id.productListView).layoutManager=layoutManager
        findViewById<RecyclerView>(R.id.productListView).adapter=adapter

    }
}