package com.example.myproject

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.my.MainProject1
import com.example.my.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.concurrent.thread

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_splash_screen)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val splashTextView = findViewById<TextView>(R.id.textView11)

        GlobalScope.launch {

            for(i in 1..5){
                delay(1000)

                launch (Dispatchers.Main){
                    splashTextView.setText( "Loading Please Wait $i")
                }
            }
        }

        thread {
            Thread.sleep(5000)
            val myIntent = Intent(this, MainProject1::class.java)
            startActivity(myIntent)
            finish()
        }

    }
}