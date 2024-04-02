package com.example.my

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import android.widget.Toolbar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LoginPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      //  enableEdgeToEdge()
        lateinit var sp: SharedPreferences
        setContentView(R.layout.activity_main_project2)
        /*ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }*/


      //var tool=findViewById<Toolbar>(R.id.toolbar5)

        sp=getSharedPreferences("myfile1", MODE_PRIVATE)
        var txt1 =findViewById<TextView>(R.id.textView6)
        var txt2 = findViewById<TextView>(R.id.textView7)
        val name=sp.getString("keyusernmae",null)
        val pswd=sp.getInt("age",0)
        txt1.setText("Name is : "+name)
        txt2.setText("Password is : "+pswd.toString())

        var Bttn=findViewById<Button>(R.id.bttn)

        Bttn.setOnClickListener{
            var editor=sp.edit()
            //editor.clear()
            //editor.apply()
            finish()
            Toast.makeText(this,"Log Out",Toast.LENGTH_LONG).show()
        }


    }
}