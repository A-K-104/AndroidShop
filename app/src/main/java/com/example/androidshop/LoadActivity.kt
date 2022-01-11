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
import kotlin.concurrent.timer

class LoadActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_load)
        sendGet(Constance.HTTP.BASE_URL)

    }
    private fun sendGet(url: String):ArrayList<Product> {

        val queue = Volley.newRequestQueue(this)
        val productList: ArrayList<Product> = ArrayList()
        val stringRequest = StringRequest(
            Request.Method.GET, url,
            { response ->
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra(Constance.IntentDataHeaders.PRODUCTS_JSON, response)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intent)

            },
            { Log.d(this.javaClass.simpleName.toString(), Constance.LogMessages.ERROR_GET_URL)
                Thread.sleep(Constance.HTTP.SLEEP_WHEN_FAILED.toLong())
                val intent = Intent(this, LoadActivity::class.java)
                intent.flags = (Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK) and
                        Intent.FLAG_ACTIVITY_NO_ANIMATION
                startActivity(intent)
            })
        queue.add(stringRequest)
        return productList

    }

}