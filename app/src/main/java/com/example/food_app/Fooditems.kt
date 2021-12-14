package com.example.food_app

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception

class Fooditems : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fooditems)
        val myApplication = application as ApiClient
        val items = mutableListOf<Fooditemsdata>()
        try {
            CoroutineScope(Dispatchers.IO).launch {
                var gson = Gson()
                var result=myApplication.apiService.GetDishes("Bearer d8b53fd6-db40-478b-8b41-22ad80e532f4")
                var res:String=""
                var i=0
                if(result!=null){
                    while(i<result.dishes!!.size){
                        items.add(result.dishes!![i])
                        res+="${result.dishes!![i].id}"
                        i+=1
                    }
                }
                withContext(Dispatchers.Main){
                    val recycle=findViewById<RecyclerView>(R.id.recycle)
                    recycle.adapter=AdapterClass(items)
                    recycle.layoutManager=LinearLayoutManager(this@Fooditems)
                }

            }
        }
        catch (e: Exception){
            Toast.makeText(this,"no data", Toast.LENGTH_LONG)
        }

        }

    }
