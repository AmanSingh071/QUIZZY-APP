package com.example.quizzy.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.quizzy.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity: AppCompatActivity() {
lateinit var  firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        firebaseAuth = FirebaseAuth.getInstance()
        txtEmail.text= firebaseAuth.currentUser?.email
        btnLogout.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
           val intent = Intent (this, LoginActivity::class.java)
           startActivity(intent)
        }
    }
}