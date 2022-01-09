package com.example.androidshop

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.*
import java.security.AccessControlContext
import java.util.logging.Logger

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val log = Logger.getLogger(MainActivity::class.java.name)

        var listView = findViewById<ListView>(R.id.listView)
        var listOfProducts : MutableList<Product> = arrayListOf();
        listOfProducts.add(Product("Apple","red","",0))
        listOfProducts.add(Product("banana","yellow","",1))
        listOfProducts.add(Product("ex","ex...","",2))
        var customAdapter = CustomAdapter(this,listOfProducts)
        listView.adapter = customAdapter

        listView.setOnItemClickListener { adapterView, view, i,l ->
            Toast.makeText(applicationContext, "Item Clicked"+customAdapter.listOfProducts[i].name,Toast.LENGTH_SHORT).show()
        }


    }
class CustomAdapter(private val context: Activity, val listOfProducts:List<Product>):BaseAdapter(){
    var images = arrayOf(R.drawable.index,R.drawable.index,R.drawable.index)

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val inflater = context.layoutInflater
        val view1 = inflater.inflate(R.layout.row_data,null)

        val fName = view1.findViewById<TextView>(R.id.fName)
        val fDesc = view1.findViewById<TextView>(R.id.fDesc)
        val fImage = view1.findViewById<ImageView>(R.id.fImage)

        fName.setText(listOfProducts[p0].name)
        fDesc.setText(listOfProducts[p0].description)
        fImage.setImageResource(images[p0])
        return view1

    }
    override fun getItem(p0: Int): Any {
        return images[p0]
    }

    override fun getItemId(p0: Int): Long {
        return images[p0].toLong()
    }
    override fun getCount(): Int {
        return images.size
    }


}
}