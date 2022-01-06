package com.example.mymultiplescreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mymultiplescreen.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            val intent = LoginActivity.getIntent(this)
            startActivity(intent)
        }

        binding.btnImageGuess.setOnClickListener {
            val intent = ImageGuessActivity.getIntent(this)
            startActivity(intent)
        }

        binding.btnDesign.setOnClickListener {
            val intent = MaterialDesignActivity.getIntent(this)
            startActivity(intent)
        }

        binding.btnLifeCycle.setOnClickListener {
//            val intent = Intent(Intent.ACTION_VIEW, "https://www.google.com".toUri())
            val intent = Intent(this, GameActivity::class.java)
            startActivity(intent)
        }

        binding.btnIntent.setOnClickListener {
            Intent(this, IntentActivity::class.java).also {
                startActivity(it)
            }
        }

        binding.btnMobile.setOnClickListener {
            Intent(this, PlayGroundActivity::class.java).also {
                startActivity(it)
            }
        }

        binding.btnListView.setOnClickListener {
            val intent = Intent(this, ListViewActivity::class.java)
            startActivity(intent)
        }

        binding.btnRecyclerView.setOnClickListener {
            val intent = Intent(this, RecyclerListActivity::class.java)
            startActivity(intent)
        }

    }
}