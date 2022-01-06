package com.example.mymultiplescreen.data

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.mymultiplescreen.R
import com.example.mymultiplescreen.model.Person


class PersonListAdapter(private val list: ArrayList<Person>, private val context: Context) :
    RecyclerView.Adapter<PersonListAdapter.ViewHolder>() {


    override fun getItemCount(): Int {
        return list.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): ViewHolder {
        // Create our view from xml file

        val view = LayoutInflater.from(context).inflate(R.layout.list_row, parent, false)

        return ViewHolder(view, context)
    }

    inner class ViewHolder(itemView: View, context: Context) : RecyclerView.ViewHolder(itemView) {
        fun bindItem(person: Person) {
            var name: TextView = itemView.findViewById(R.id.name) as TextView
            var age: TextView = itemView.findViewById(R.id.age) as TextView

            name.text = person.name
            age.text = person.age.toString()

            itemView.setOnClickListener {
                Toast.makeText(context, name.text, Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(list[position])
    }


}