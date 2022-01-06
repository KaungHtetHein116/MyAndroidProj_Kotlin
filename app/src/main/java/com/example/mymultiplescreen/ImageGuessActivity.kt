package com.example.mymultiplescreen

import android.content.Context
import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mymultiplescreen.databinding.ActivityImageGuessBinding
import com.google.android.material.snackbar.Snackbar

class ImageGuessActivity : AppCompatActivity() {


    private lateinit var binding: ActivityImageGuessBinding
    var isStart = false
    private var fruits = listOf(R.drawable.apple, R.drawable.orange)
    var selectedImage = R.drawable.no_image


    companion object {
        fun getIntent(context: Context): Intent {
            val intent = Intent(context, ImageGuessActivity::class.java)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityImageGuessBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.switchFruit.setOnCheckedChangeListener{ _, isChecked ->
            toggleImage(isChecked)
        }

        binding.btnRandom.setOnClickListener {
            var randomImage = (fruits).shuffled().first()

            if (isStart){
                binding.imgRandom.setImageResource(randomImage)
                if (selectedImage == randomImage){
                    Snackbar.make(it, "You won !!!", Snackbar.LENGTH_LONG).show()

                }
            } else {
                Snackbar.make(it, "Switch to start the game", Snackbar.LENGTH_LONG).show()
            }
        }

        binding.btnApple.setOnClickListener {
            if (isStart){
                binding.imgGuess.setImageResource(R.drawable.apple)
                selectedImage = R.drawable.apple
            } else {
                Snackbar.make(it, "Switch to start the game", Snackbar.LENGTH_LONG).show()
            }
        }

        binding.btnOrange.setOnClickListener {
            if (isStart){
                binding.imgGuess.setImageResource(R.drawable.orange)
                selectedImage = R.drawable.orange
            } else {
                Snackbar.make(it, "Switch to start the game", Snackbar.LENGTH_LONG).show()
            }
        }
    }

    private fun checkWinOrLose () {

    }

    private fun toggleImage(isChecked: Boolean) {
        if (isChecked) {
            binding.switchFruit.text = getString(R.string.stop_game)
            isStart = true
        } else {
            binding.switchFruit.text = getString(R.string.start_game)
            isStart = false
        }
    }
}