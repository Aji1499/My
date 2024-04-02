package com.example.my

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        //setContentView(R.layout.lay)

        var submitButton=findViewById<Button>(R.id.buttonsubmit)
        var edittext=findViewById<EditText>(R.id.editTextEmailAddress)
        //var viewText=findViewById<TextView>(R.id.textView2)
        var viewedit=findViewById<EditText>(R.id.editTextNumberPassword)


        submitButton.setOnClickListener{
            var username=edittext.text.toString()
            var pswd=viewedit.text.toString()
            if(username == "Ajith"&& pswd== "123")
            {
                var myintent= Intent(this,prof::class.java)
                myintent.putExtra("keyusername1",username)
                myintent.putExtra("keypswd",pswd)
                startActivity(myintent)
            }
            else
                Toast.makeText(this,"username is $username and password is $pswd is wrong",Toast.LENGTH_LONG).show()
            edittext.setText(username)
            viewedit.setText(pswd)

            /*override fun onStart() {
                super.onStart()
                Log.e("mytag","main Activity started")
            }

            override fun onResume() {
                super.onResume()
                Log.d("mytag","main Acitivity created")
            }

            override fun onRestart() {
                super.onRestart()
                Log.i("mytag","main Activity started")
            }
            */




        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}