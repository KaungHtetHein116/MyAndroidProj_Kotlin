package com.example.mymultiplescreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.DisplayMetrics
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mymultiplescreen.data.PersonListAdapter
import com.example.mymultiplescreen.databinding.ActivityListViewBinding
import com.example.mymultiplescreen.model.Person
import kotlin.random.Random

class ListViewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityListViewBinding

    private var adapter: PersonListAdapter? = null
    private var personList: ArrayList<Person>? = null
    private var layoutManager: RecyclerView.LayoutManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)

        var width = displayMetrics.widthPixels
        var height = displayMetrics.heightPixels

        personList = ArrayList()
        layoutManager = LinearLayoutManager(this)
        adapter = PersonListAdapter(personList!!, this)

        // setup list for recycler view

        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.adapter = adapter

        // load data

        for (i in 0..9) {
            val person = Person()
            person.name = "kaung $i"
            person.age = 24 + i
            personList!!.add(person)
        }


        binding.btnAdd.setOnClickListener {
            var itemName = binding.tvAddItem.text.toString()

            var person = Person()
            person.name = itemName
            person.age = 246666

            personList!!.add(person)

            Toast.makeText(this, "added $itemName", Toast.LENGTH_SHORT).show()

            adapter!!.notifyItemInserted(personList!!.size )

        }
    }
}