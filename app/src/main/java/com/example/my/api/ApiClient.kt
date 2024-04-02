package com.example.my.api


import com.example.my.datas.DataClass
import retrofit2.http.GET
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


interface ApiService {                                     //
    @GET("photos")
    fun getData() :  Call<List<DataClass>>

}
class ApiClient {

    companion object{                                       //like static function
        var retroBuilder=Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }


}