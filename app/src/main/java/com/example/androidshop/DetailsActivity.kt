package com.example.androidshop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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

        val g: Product =
            intent.getSerializableExtra(Constance.IntentDataHeaders.SINGLE_PRODUCT) as Product

        val iv_product_icon = findViewById<ImageView>(R.id.iv_product_icon)
        val tName = findViewById<TextView>(R.id.tName)
        val tDescription = findViewById<TextView>(R.id.tDescription)
        val tPrice = findViewById<TextView>(R.id.tPrice)
        val bBack = findViewById<ImageButton>(R.id.bBack)

        Picasso.get().load(g.imageLink).resize(
            Constance.ImagesSizes.BIG_IMAGE_ICON,
            Constance.ImagesSizes.BIG_IMAGE_ICON
        ).into(iv_product_icon, object : Callback {
            override fun onSuccess() {
            }

            override fun onError(e: Exception?) {
                Log.d(
                    this.javaClass.simpleName.toString(),
                    "${Constance.LogMessages.ERROR_GET_IMAGE_URL} $e"
                )
                Toast.makeText(
                    this@DetailsActivity,
                    "${Constance.LogMessages.ERROR_GET_IMAGE_URL} $e",
                    Toast.LENGTH_SHORT
                )
                    .show()
                iv_product_icon.setImageResource(R.drawable.error_image)
            }
        })

        tName.text = g.name
        tDescription.text = g.description
        tPrice.text = g.price.toString()
        bBack.setOnClickListener {
            finish()
        }
    }
}