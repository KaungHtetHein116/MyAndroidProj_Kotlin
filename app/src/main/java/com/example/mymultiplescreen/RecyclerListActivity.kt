package com.example.mymultiplescreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mymultiplescreen.data.CustomAdapter
import com.example.mymultiplescreen.databinding.ActivityRecyclerListBinding
import com.example.mymultiplescreen.model.ItemsViewModel

class RecyclerListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRecyclerListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecyclerListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val recyclerview = findViewById<RecyclerView>(R.id.recyclerview)

        // this creates a vertical layout Manager
        recyclerview.layoutManager = LinearLayoutManager(this)

        // ArrayList of class ItemsViewModel
        val data = ArrayList<ItemsViewModel>()

        // This loop will create 20 Views containing
        // the image with the count of view
        for (i in 1..20) {
            data.add(ItemsViewModel(image = R.drawable.no_image, name = "name " + i,description = "Description DescriptionDescriptionDescriptionDescriptionDescriptionDescriptionDescriptionDescriptionDescriptionDescriptionDescriptionDescription " + i))
        }

        // This will pass the ArrayList to our Adapter
        val adapter = CustomAdapter(data)

        // Setting the Adapter with the recyclerview
        recyclerview.adapter = adapter

    }
}