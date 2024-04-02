package com.example.my

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.my.datas.DataClass
import com.squareup.picasso.Picasso

class AdapterClass(var dataList: ArrayList<DataClass>) : RecyclerView.Adapter<AdapterClass.ViewHolderClass>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderClass {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.activity_main_project_layout,parent,false)
        return ViewHolderClass(itemView)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: ViewHolderClass, position: Int) {

        holder.bindData(dataList[position])
        holder.itemView.findViewById<ImageView>(R.id.imageView3).setOnClickListener(){
            var intent10=Intent(holder.itemView.context, Product::class.java)
          // holder.itemView.context.startActivity(intent10)
            intent10.putExtra("title", dataList[position].title)
            intent10.putExtra("url", dataList[position].url)
            holder.itemView.context.startActivity(intent10)
        }
    }
    class ViewHolderClass(itemView: View): RecyclerView.ViewHolder(itemView) {
        val rvImage : ImageView = itemView.findViewById(R.id.imageView3)
        val rvText : TextView = itemView.findViewById(R.id.textView9)

        fun bindData(prodcuts:DataClass){
           //rvText.setText(prodcuts.title)
            rvText.text=prodcuts.title
            Picasso.with(rvImage.context).load(prodcuts.url).into(rvImage)
        }

    }

}