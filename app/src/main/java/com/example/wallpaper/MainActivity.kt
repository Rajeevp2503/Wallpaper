package com.example.wallpaper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.wallpaper.model.Wallpaper
import com.example.wallpaper.model.WallpaperApiResponse
import com.example.wallpaper.model.WallpaperData
import com.example.wallpaper.model.WallpaperPost
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //val recycler = findViewById<RecyclerView>(R.id.recyclerView)

        //fetchData()

        // recycler.layoutManager = LinearLayoutManager(this)
        val items  = fetchData()
        items.size
      //  val adapter  = WallAdapter(items)
       // recycler.adapter= adapter

    }

    /* fun fetchData(): ArrayList<String>{
        val list = ArrayList< String>()
        for (i in 0 until 100){
            list.add("Item $i")
        }
        return list
    }*/
    fun fetchData() : ArrayList<WallpaperPost> {
        val url = "https://www.reddit.com/r/wallpapers.json"
        val queue = Volley.newRequestQueue(this)


       val imgg = ArrayList<WallpaperPost>()


        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET,url,null,
        Response.Listener {

            Log.d("Main Activity ","api call success")

            val obj = it.toString()

            val wallpaperApiResponse: WallpaperApiResponse = Gson()
                .fromJson<WallpaperApiResponse>(obj, WallpaperApiResponse::class.java);

            val wallpaperData : WallpaperData

            for(i in 0 until wallpaperApiResponse.data.dist){

                var wallpaperPost : WallpaperPost

               /* var tit : String =  wallpaperApiResponse.data.children[i].data.title
                var urlll : String =  wallpaperApiResponse.data.children[i].data.urlOverriddenByDest*/


                /*wallp =  Wallpclass(tit,urlll)
                wallp.title?.let { it1 -> Log.e("details", it1) }*/
                imgg.add(wallpaperApiResponse.data.children[i])

            }
        },Response.ErrorListener {
                Log.d("Main Activity ","api call not successfull")

            })
        queue.add(jsonObjectRequest)

        return imgg
    }

}