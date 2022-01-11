package com.example.androidshop

import android.annotation.SuppressLint
import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.squareup.picasso.Picasso
import android.content.Intent
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import com.squareup.picasso.Callback
import org.json.JSONArray
import org.json.JSONObject
import java.lang.Exception


class MainActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView = findViewById<ListView>(R.id.listView)
        val re: String = intent.getStringExtra(Constance.IntentDataHeaders.PRODUCTS_JSON) as String

        val listOfProducts = parseJson(re)
        val customAdapter = CustomAdapter(this, listOfProducts)
        listView.adapter = customAdapter

        listView.setOnItemClickListener { _, _, i, _ ->
            val intent = Intent(this@MainActivity, DetailsActivity::class.java)
            intent.putExtra(
                Constance.IntentDataHeaders.PRODUCTS_JSON,
                customAdapter.listOfProducts[i]
            )
            startActivity(intent)
        }
    }

    class CustomAdapter(private val context: Activity, val listOfProducts: ArrayList<Product>) :
        BaseAdapter() {
        @SuppressLint("ViewHolder", "InflateParams")
        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            val inflater = context.layoutInflater
            val view1 = inflater.inflate(R.layout.row_data, null)

            val fName = view1.findViewById<TextView>(R.id.fName)
            val fImage = view1.findViewById<ImageView>(R.id.fImage)

            fName.text = listOfProducts[p0].name
            Picasso.get().load(listOfProducts[p0].imageLink).resize(
                Constance.ImagesSizes.SMALL_IMAGE_BOX_WIDTH,
                Constance.ImagesSizes.SMALL_IMAGE_BOX_HEIGHT
            )
                .into(fImage, object : Callback {
                    override fun onSuccess() {
                    }

                    override fun onError(e: Exception?) {
                        Log.d(
                            this.javaClass.simpleName.toString(),
                            "${Constance.LogMessages.ERROR_GET_IMAGE_URL} $e"
                        )
                        Toast.makeText(
                            context,
                            "${Constance.LogMessages.ERROR_GET_IMAGE_URL} $e",
                            Toast.LENGTH_SHORT
                        )
                            .show()
                        fImage.setImageResource(R.drawable.error_image)
                    }
                })
            return view1

        }

        override fun getItem(p0: Int): Any {
            return listOfProducts
        }

        override fun getItemId(p0: Int): Long {
            return listOfProducts[p0].name.hashCode().toLong()
        }

        override fun getCount(): Int {
            return listOfProducts.size
        }
    }

    private fun parseJson(response: String): ArrayList<Product> {
        val productList: ArrayList<Product> = ArrayList()
        val json = JSONObject(response)
        val list = json.get(Constance.JsonHeaders.DATA_MAIN_HEADER) as JSONArray
        for (i in 0 until list.length()) {
            productList.add(
                Product(list.getJSONObject(i))
            )
        }
        return productList
    }

}