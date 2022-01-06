package com.example.mymultiplescreen
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mymultiplescreen.databinding.ActivitySecondIntentBinding


class SecondIntent : AppCompatActivity() {
    private lateinit var binding: ActivitySecondIntentBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding = ActivitySecondIntentBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val actionBar = supportActionBar

        actionBar!!.title = "Second Intent Screen"

        actionBar.setDisplayHomeAsUpEnabled(true)

//        val person = intent.getSerializableExtra("EXTRA_PERSON") as Person

//        binding.tvPerson.text = person.toString()
    }

    override fun onBackPressed() {
        var returnIntent = this.intent
        returnIntent.putExtra("EXTRA_RETURN", "hello i am back")
        setResult(Activity.RESULT_OK, returnIntent)
        super.onBackPressed()
    }
}
