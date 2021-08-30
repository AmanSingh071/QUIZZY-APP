package com.example.quizzy.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.quizzy.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.login_intro.*
import kotlinx.android.synthetic.main.logn_in.*


class LoginActivity : AppCompatActivity() {
    lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_intro)
        firebaseAuth= FirebaseAuth.getInstance()
        LogIn.setOnClickListener{
            login()
        }
        SignUp.setOnClickListener{
            val intent= Intent(this, SignupActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
   private fun login()
   {
       val email =etEmailAddress.text.toString()
       val password =etPassword.text.toString()
       firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this){
           if(it.isSuccessful){
               Toast.makeText(this,"Success",Toast.LENGTH_SHORT).show()
               val intent= Intent(this, MainActivity::class.java)
               startActivity(intent)
               finish()
           }
           else
           {
               Toast.makeText(this, "Authentication Failed", Toast.LENGTH_SHORT).show()
           }
       }
   }
}

