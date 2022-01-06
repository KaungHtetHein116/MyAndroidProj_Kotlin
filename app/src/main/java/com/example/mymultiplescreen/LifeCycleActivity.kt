package com.example.mymultiplescreen

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import com.example.mymultiplescreen.databinding.ActivityLifeCycleBinding
import kotlin.random.Random

class LifeCycleActivity : AppCompatActivity() {

//    companion object {
//        fun getIntent(context: Context): Intent {
//            val intent = Intent(context, LifeCycleActivity::class.java)
//            return intent
//        }
//    }

    private lateinit var extra: String
    private lateinit var message: String
    private val btnDraw by lazy { binding.btnDraw }
    private val txtDisplay by lazy { binding.tvDisplay }
    private val imageViews by lazy { listOf<ImageView>(binding.imageView1, binding.imageView2, binding.imageView3) }
    private lateinit var images: IntArray


    private lateinit var binding: ActivityLifeCycleBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityLifeCycleBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        initImageViews()

        extra = intent.getStringExtra(HEADER) ?: "Show that apple"

        message = savedInstanceState?.getString(MESSAGE) ?: "Show that apple"
        images = savedInstanceState?.getIntArray(IMAGES) ?: intArrayOf(R.drawable.no_image, R.drawable.no_image, R.drawable.no_image)

        displayMessage()
        displayRandomImage()

        btnDraw.setOnClickListener { drawSlotMachine() }
        Log.i(SHOW_IMAGE_TAG, "onCreate fires !!!")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putString(MESSAGE, message)
        outState.putIntArray(IMAGES, images)
        super.onSaveInstanceState(outState)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_game, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.itemShare){
            val intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, "Lucky Apple slot machine:\n" + "You draw :${getAppleCount().toString()} apple(s)")

                type = "text/plain"
            }

            startActivity(intent)
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun finish() {
        val data = Intent()
        data.putExtra("return", "Thank you for playing")
        setResult(Activity.RESULT_OK, data)
        super.finish()
    }

    private fun displayMessage() {
        when (getAppleCount()){
            1 -> message = "One apple"
            2 -> message = "Two apples"
            3 -> message = "Three apples"
            else -> message = extra
        }

        txtDisplay.text = message
    }

    private fun getAppleCount(): Int {
        var counterApple = 0
        for (i in images){
            if (R.drawable.apple == i)
                counterApple ++
        }

        return counterApple
    }

    private fun drawSlotMachine() {
        setRandomImages()
        displayRandomImage()
        displayMessage()
    }

    private fun displayRandomImage() {
        for (i in 0 until images.size) {
            imageViews[i].setImageResource((images[i]))
        }
    }

    private fun randomizeImage(): Int {
        val r = Random.nextInt(3)
        return when(r){
            0 -> R.drawable.apple
            1 -> R.drawable.grapes
            2 -> R.drawable.orange
            else -> R.drawable.no_image
        }
    }

    private fun setRandomImages () {
        images = intArrayOf(randomizeImage(), randomizeImage(), randomizeImage())
    }

    private fun initImageViews() {
        for (i in imageViews) i.setImageResource(R.drawable.no_image)
    }

    override fun onStart() {
        super.onStart()
        Log.i(SHOW_IMAGE_TAG, "onStart fires !!")
    }

    override fun onResume() {
        super.onResume()
        Log.i(SHOW_IMAGE_TAG, "onResume fires !!")
    }

    override fun onPause() {
        super.onPause()
        Log.i(SHOW_IMAGE_TAG, "onPause fires !!")
    }

    override fun onStop() {
        super.onStop()
        Log.i(SHOW_IMAGE_TAG, "onStop fires !!")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(SHOW_IMAGE_TAG, "onDestroy fires !!")
    }


}