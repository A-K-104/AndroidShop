package com.example.androidshop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import java.lang.Exception

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        val g: Product = intent.getSerializableExtra("USER_CLASS") as Product
        val iv_product_icon = findViewById<ImageView>(R.id.iv_product_icon)
        val tName = findViewById<TextView>(R.id.tName)
        val tDescription = findViewById<TextView>(R.id.tDescription)
        val tPrice = findViewById<TextView>(R.id.tPrice)
        val bBack = findViewById<ImageButton>(R.id.bBack)

        Picasso.get().load(g.imageLink).resize(400,400).into(iv_product_icon, object: Callback {
            override fun onSuccess() {
            }

            override fun onError(e: Exception?) {
                Toast.makeText(this@DetailsActivity, "Error loading image: $e", Toast.LENGTH_SHORT).show()
                iv_product_icon.setImageResource(R.drawable.error_image)
            }
        })

        tName.text=g.name
        tDescription.text=g.description
        tPrice.text = g.price.toString()
        bBack.setOnClickListener {
            finish()
        }
    }
}