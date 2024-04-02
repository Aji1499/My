package com.example.my

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class RegisterPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        lateinit var sp: SharedPreferences
        setContentView(R.layout.activity_main_project3)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        sp= getSharedPreferences("myfile1", MODE_PRIVATE)

        var button07=findViewById<Button>(R.id.button00)
        var userName= findViewById<EditText>(R.id.editTextText)
        var nterage= findViewById<EditText>(R.id.editTextNumberPassword2)

        button07.setOnClickListener{
            val username= userName.text.toString()
            var age= nterage.text.toString().toInt()
            var editor=sp.edit() //for write to sharedpreference we need editor
            editor.apply()
            {
                putString("keyusernmae", username) // to save string to sp as a key value pair
                putInt("age",age)                  // to save age to sp
                apply()                            // to finish
            }

            var inte=Intent(this,MainProject1::class.java)
            startActivity(inte)
            Toast.makeText(this," username is : $username,password is : $age", Toast.LENGTH_LONG).show()
        }


    }
}