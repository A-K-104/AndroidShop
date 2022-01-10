package com.example.androidshop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray
import org.json.JSONObject

class LoadActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_load)
        val url = "https://dev-api.com/fruitsBT/getFruits"

        sendGet(url)

    }
    private fun sendGet(url: String):ArrayList<Product> {

        val queue = Volley.newRequestQueue(this)

        val productList: ArrayList<Product> = ArrayList()
        val stringRequest = StringRequest(
            Request.Method.GET, url,
            { response ->
                // Display the first 500 characters of the response string.

                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("USER_CLASS", response)
                startActivity(intent)

            },
            { Log.d("req", "That didn't work!") })
        queue.add(stringRequest)
        return productList

    }
}