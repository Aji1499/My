package com.example.my

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainProject1 : AppCompatActivity() {





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        lateinit var sp: SharedPreferences
        setContentView(R.layout.activity_main_project1)





        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }
        sp= getSharedPreferences("myfile1", MODE_PRIVATE)
        var btn=findViewById<Button>(R.id.savebtn)
        var userName=findViewById<EditText>(R.id.entername)
        var pswd1=findViewById<EditText>(R.id.enterpswd)
        var loadButton=findViewById<Button>(R.id.Loadbutton)
        var register=findViewById<TextView>(R.id.textView8)

        //userName.setText((sp.getString("keyusername","")))
        btn.setOnClickListener{
            val username= userName.text.toString()
            var age= pswd1.text.toString().toInt()

                var username1 = sp.getString("keyusernmae","username") // to save string to sp as a key value pair
                var pswd = sp.getInt("age", 0)

                if (username1.equals(username)){
                    var myintent2 = Intent(this, DashBoard::class.java)
                    startActivity(myintent2)
                }
            else
                {
                    Toast.makeText(this, "Incorrect username and password", Toast.LENGTH_LONG).show()
                }

        }
        register.setOnClickListener {
            var myintent0=Intent(this,RegisterPage::class.java)
            startActivity(myintent0)
        }

        loadButton.setOnClickListener{
           // userName.setText((sp.getString("keyusername","")))
            val name=sp.getString("keyusernmae",null)
            val pswd2=sp.getInt("age",0)

            userName.setText(name)
            pswd1.setText(pswd2.toString())

        }




    }





}


