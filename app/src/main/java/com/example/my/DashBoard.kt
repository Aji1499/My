package com.example.my

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.my.api.ApiClient
import com.example.my.datas.DataClass
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DashBoard : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()


        setContentView(R.layout.activity_dash_board)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var recyclerView =findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager=StaggeredGridLayoutManager(1,LinearLayoutManager.VERTICAL)
        val mydata =ArrayList<DataClass>()
       // mydata.add(DataClass("ajith","https://via.placeholder.com/600/e924e6"))

        var adapter=AdapterClass(mydata)
        recyclerView.adapter=adapter

        var apiCall = ApiClient.retroBuilder.getData()

        /*apiCall.enqueue(object : Callback<List<DataClass>>{
            override fun onResponse(
                call: Call<List<DataClass>>,
                response: Response<List<DataClass>>
            ) {
                TODO("Not yet implemented")
            }

            override fun onFailure(call: Call<List<DataClass>>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })*/
        apiCall.enqueue(object : Callback<List<DataClass>>{
            override fun onResponse(
                call: Call<List<DataClass>>?,
                response: Response<List<DataClass>>?
            ) {
                var products: List<DataClass>? = response?.body()
                Log.i("products", "$products")
                if (products != null){
                    mydata.clear()
                    mydata.addAll(products)
                    adapter.notifyDataSetChanged()
                }
            }

            override fun onFailure(call: Call<List<DataClass>>, t: Throwable) {
                Log.i("api_error", "Error in api ${t.toString()}")
                Toast.makeText(applicationContext,"Error in getting data from API, Check Your Internet!",Toast.LENGTH_LONG).show();
            }
        })

    }
}
