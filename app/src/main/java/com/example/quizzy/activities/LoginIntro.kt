package com.example.quizzy.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.quizzy.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login_intro.*
import java.lang.Exception

class LoginIntro: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_intro)
        val auth= FirebaseAuth.getInstance()
        if(auth.currentUser!=null)
        {
            Toast.makeText(this,"User is already LogIn", Toast.LENGTH_SHORT).show()
            redirect("MAIN")
        }
        btnGetStarted.setOnClickListener {
            redirect ("LOGIN")
        }
    }
    private fun redirect(name:String)
    {
        val intent : Intent =when (name)
        {
            "LOGIN" -> Intent(this, LoginActivity::class.java)
            "MAIN" -> Intent(this, MainActivity::class.java)
            else -> throw Exception ("no path exists")

        }
        startActivity(intent)
        finish()

    }    }