package com.example.quizzy.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.quizzy.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.logn_in.*

open class SignupActivity : AppCompatActivity() {
    lateinit var  firebaseAuth :FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.logn_in)
        firebaseAuth= FirebaseAuth.getInstance()
        btnSignUp.setOnClickListener{
            signUpUser()
        }
        btnLogIn.setOnClickListener{
            val intent= Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
    private fun signUpUser(){
        val email =etEmailAddress.text.toString()
        val password =etPassword.text.toString()
        val confirmPassword = etConfirmPassword.text.toString()

        if(email.isBlank()|| password.isBlank()|| confirmPassword.isBlank())
        {
            Toast.makeText(this,"Email and Password can't be blank",Toast.LENGTH_SHORT).show()
            return
        }
        if(password!= confirmPassword)
        {
            Toast.makeText(this,"Password and Confirm Password do not match",Toast.LENGTH_SHORT).show()
            return
        }
firebaseAuth.createUserWithEmailAndPassword(email, password)
    .addOnCompleteListener(this){
        if(it.isSuccessful){
            Toast.makeText(this,"SignUp Successful",Toast.LENGTH_SHORT).show()
            val intent= Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
        else
        {
            Toast.makeText(this,"Error creating user",Toast.LENGTH_SHORT).show()
        }
    }
    }
}