package com.example.coderswag.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.coderswag.R
import com.example.coderswag.model.Category

class CategoryRecycleAdapter(val context:Context,val categories:List<Category>): Adapter<CategoryRecycleAdapter.Holder>(){
    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val categoryImage=itemView.findViewById<ImageView>(R.id.categoryimage)
        val categoryName=itemView.findViewById<TextView>(R.id.categoryName)
        fun bindCategory(category: Category,context: Context){
            val resourceId=context.resources.getIdentifier(category.image,"drawable",context.packageName)
            categoryImage?.setImageResource(resourceId)
            categoryName?.text=category.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {//This method is called when new holders are needed
        val view=LayoutInflater.from(parent.context).inflate(R.layout.category_list_item,parent,false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {//This is used in recycler view display the data at a specified location through process known as binding
        holder.bindCategory(categories[position],context)

    }

    override fun getItemCount(): Int {//This is used to tell recycler view how many categories are used.
       return categories.count()
    }
}