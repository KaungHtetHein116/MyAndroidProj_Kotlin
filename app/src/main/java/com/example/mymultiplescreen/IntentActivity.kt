package com.example.mymultiplescreen

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.mymultiplescreen.databinding.ActivityIntentBinding

class IntentActivity : AppCompatActivity() {
    private lateinit var binding: ActivityIntentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityIntentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSubmit.setOnClickListener {
            Toast.makeText(this, "Hi", Toast.LENGTH_SHORT).show()

//            var name = binding.txtName.text.toString()
//            var age = binding.txtAge.text.toString().toInt()
//            var country = binding.txtCountry.text.toString()
//            var person = Person(name, age, country)
//
//            Intent(this, SecondIntent::class.java).also {
//                it.putExtra("EXTRA_PERSON", person)
//                startActivity(it)
//
//            }
        }
    }

   


}