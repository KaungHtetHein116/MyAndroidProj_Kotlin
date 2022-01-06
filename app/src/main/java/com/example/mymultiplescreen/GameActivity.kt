package com.example.mymultiplescreen

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.mymultiplescreen.databinding.ActivityGameBinding

class GameActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGameBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnGameStart.setOnClickListener {
            val intent = Intent(this, LifeCycleActivity::class.java)
            intent.putExtra(HEADER, "Press Draw")
            startActivityForResult(intent, 1)
            //startActivity(intent)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

            val returnValue = data?.getStringExtra("return") ?: "Welcome Player"

            binding.txtGame.text = returnValue
        }

}