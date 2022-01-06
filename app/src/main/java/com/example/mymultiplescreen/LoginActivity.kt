package com.example.mymultiplescreen

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.example.mymultiplescreen.databinding.ActivityLoginBinding
import com.google.android.material.snackbar.Snackbar
import java.util.*
import kotlin.system.exitProcess

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    companion object {
        fun getIntent(context: Context): Intent {
            val intent = Intent(context, LoginActivity::class.java)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {



        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSubmit.setOnClickListener{
            validateUser(it)
        }

    }

    private fun addTextView(text: String){
        val textView = TextView(this)
        textView.text = text
        textView.textSize = 16f
        textView.textAlignment = View.TEXT_ALIGNMENT_CENTER
        binding.myLayout.addView(textView)
    }

    private fun validateUser(it: View) {
        val username = binding.editUsername.text
        val password = binding.editPassword.text
        val message = getString(R.string.welcome_message, username)

        if (username.toString().equals("Kaung", true) && password.toString().equals("1234")) {
            val snack = Snackbar.make(it, message, Snackbar.LENGTH_LONG)
            snack.setAction("Show Details ...", { addTextView("Login Successful: ${Calendar.getInstance().time}") })
            snack.show()
            username?.clear()
            password?.clear()
        } else {
            Toast.makeText(this, "Invalid credential", Toast.LENGTH_SHORT).show()
        }
    }

    private fun displayToast () {
        Toast.makeText(this, "Login Successful: ${Calendar.getInstance().time}", Toast.LENGTH_SHORT).show()
    }
}