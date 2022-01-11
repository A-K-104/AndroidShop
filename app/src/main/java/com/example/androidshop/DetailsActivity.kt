package com.example.androidshop

import android.annotation.SuppressLint
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
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val product: Product =
            intent.getSerializableExtra(Constance.IntentDataHeaders.SINGLE_PRODUCT) as Product

        val ivProduct_icon = findViewById<ImageView>(R.id.iv_product_icon)
        val tName = findViewById<TextView>(R.id.tName)
        val tDescription = findViewById<TextView>(R.id.tDescription)
        val tPrice = findViewById<TextView>(R.id.tPrice)
        val bBack = findViewById<ImageButton>(R.id.bBack)

        tName.text = product.name
        tDescription.text = product.description
        tPrice.text = "${Constance.XmlString.PRODUCT_PRICE} ${product.price}"
        bBack.setOnClickListener {
            finish()
        }

        Picasso.get().load(product.imageLink).resize(
            Constance.ImagesSizes.BIG_IMAGE_ICON,
            Constance.ImagesSizes.BIG_IMAGE_ICON
        ).into(ivProduct_icon, object : Callback {
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
                ivProduct_icon.setImageResource(R.drawable.error_image)
            }
        })

    }
}