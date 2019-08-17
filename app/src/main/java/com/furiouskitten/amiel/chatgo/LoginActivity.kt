package com.furiouskitten.amiel.chatgo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        login_button_login.setOnClickListener{
            loginUser()
        }
    }

    private fun loginUser() {

        var email = email_edittext_login.text.toString()
        var password = password_edittext_login.text.toString()
        var auth : FirebaseAuth = FirebaseAuth.getInstance()


        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this){
            task -> if (task.isSuccessful ){
                Toast.makeText(this,"Logged in as + $email", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this,"Login Failed", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
