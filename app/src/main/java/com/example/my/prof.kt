package com.example.my

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar

class prof : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_profile2)
        var submitButton2=findViewById<Button>(R.id.buttonProfile2)

        submitButton2.setOnClickListener{
            var myintent1= Intent(this,MainActivity::class.java)
            startActivity(myintent1)
        }
        var submitButton3=findViewById<Button>(R.id.button3)

        submitButton3.setOnClickListener{
            var myintent2= Intent(this,profile3::class.java)
            startActivity(myintent2)
        }

        var textview=findViewById<TextView>(R.id.textView4)
        //var textView1=findViewById<TextView>(R.id.textView5)
        var result=intent.extras!!.getString("keyusername1")
        var result2=intent.extras!!.getString("keypswd")
        textview.text="you entered username is : $result" +
                        " password is :$result2"

        var listview=findViewById<ListView>(R.id.listView1)

       var countries= arrayOf("sffe","sfesf","fssf","btff","dtbb","sbtdb","truu","tjtjy")
        var arrayAdapter=ArrayAdapter(this,android.R.layout.simple_list_item_1,countries)
        listview.adapter=arrayAdapter

        /*var myintent=Intent(Intent.ACTION_VIEW, Uri.parse("https://google.com"))
        startActivity(myintent )*/

       /* var myintent=Intent(Intent.ACTION_VIEW, Uri.parse("http://maps.google.com/maps?q=happy homes men's pg"))
        startActivity(myintent )*/
        // pop up varum
        var textv=findViewById<TextView>(R.id.textView5)
        textv.setOnClickListener {
            var alertDialog=AlertDialog.Builder(this)
            alertDialog.setTitle("My alert Dialog")
            alertDialog.setMessage("Do you want to continue")
            alertDialog.setCancelable(false)

            alertDialog.setPositiveButton("yes") { dialog, which ->
                var rootview = findViewById<View>(android.R.id.content) //show the current layout
                var mySnackbar = Snackbar.make(rootview, "this is snackbar", Snackbar.LENGTH_LONG)
                //mySnackbar.view.setBackgroundColor(Color.parseColor("#FF5722"))
                mySnackbar.setBackgroundTint(ContextCompat.getColor(this, R.color.Ajith)) // for change the background color of the snackbar
                mySnackbar.setAction("Click me") {
                    Toast.makeText(this, "toast from snackbar", Toast.LENGTH_SHORT).show()
                }
                mySnackbar.show()
            }
            alertDialog.setNegativeButton("no") { dialog, which ->
            this.finish()
            }
            alertDialog.show()


        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }


}