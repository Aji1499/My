package com.example.my

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.example.my.datas.DataClass
import com.squareup.picasso.Picasso

class Product : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // enableEdgeToEdge()
        setContentView(R.layout.activity_product)
        /*ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }*/


        /*val data = intent.getParcelableExtra<DataClass>("data")
        if(data != null){
            val textView = findViewById<TextView>(R.id.textView10)
            val imageView = findViewById<ImageView>(R.id.imageView4)
            Glide.with(this).load(data?.thumbnailUrl).into(imageView)

            textView.text = data?.title
        }*/

        //intent.extras!!.getString("title", "default")

        var rvImage1 = findViewById<ImageView>(R.id.imageView4)
        var rvText1  = findViewById<TextView>(R.id.textView10)


        var vari= intent.extras!!.getString("title", "default")
        var url1= intent.extras!!.getString("url", "default")
        Log.i("vari", "$vari, $url1")

        Picasso.with(this).load(url1).into(rvImage1)



    }
}