package com.example.mymultiplescreen

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mymultiplescreen.databinding.ActivityMaterialDesignBinding

class MaterialDesignActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMaterialDesignBinding

    companion object {
        fun getIntent(context: Context): Intent {
            val intent = Intent(context, MaterialDesignActivity::class.java)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMaterialDesignBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}