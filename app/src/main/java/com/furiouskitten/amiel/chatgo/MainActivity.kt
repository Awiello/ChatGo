package com.furiouskitten.amiel.chatgo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        haveaccount_text_register.setOnClickListener {
            var haveAccountIntent = Intent(this, LoginActivity::class.java)
            startActivity(haveAccountIntent)
            finish()
        }

        register_button_register.setOnClickListener {

            createUser()

        }

    }

    private fun createUser() {

        var email = email_edittext_register.text.toString()
        var password = password_edittext_register.text.toString()
        var auth: FirebaseAuth = FirebaseAuth.getInstance()

        //Firebase Authentication

        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this) { task ->
            if (task.isSuccessful) {
                // Sign in success, update UI with the signed-in user's information
                Log.d("main", "createUserWithEmail:success")
            } else {
                Log.d("main", "createUserWithEmail:fail")
            }
        }
    }
}
