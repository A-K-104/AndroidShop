package com.example.androidshop
import android.annotation.SuppressLint
import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.squareup.picasso.Picasso


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val listView = findViewById<ListView>(R.id.listView)
        val listOfProducts : MutableList<Product> = arrayListOf();
        listOfProducts.add(Product("Apple","red",	"https://upload.wikimedia.org/wikipedia/commons/thumb/4/44/Bananas_white_background_DS.jpg/320px-Bananas_white_background_DS.jpg",0))
        listOfProducts.add(Product("banana","yellow",	"https://upload.wikimedia.org/wikipedia/commons/thumb/4/44/Bananas_white_background_DS.jpg/320px-Bananas_white_background_DS.jpg",1))
        listOfProducts.add(Product("ex","ex...",	"https://upload.wikimedia.org/wikipedia/commons/thumb/4/44/Bananas_white_background_DS.jpg/320px-Bananas_white_background_DS.jpg",2))
        val customAdapter = CustomAdapter(this,listOfProducts)
        listView.adapter = customAdapter

        listView.setOnItemClickListener { _, _, i, _ ->
            Toast.makeText(applicationContext, "Item Clicked"+customAdapter.listOfProducts[i].name,Toast.LENGTH_SHORT).show()
        }


    }
class CustomAdapter(private val context: Activity, val listOfProducts:List<Product>):BaseAdapter(){
    @SuppressLint("ViewHolder", "InflateParams")
    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val inflater = context.layoutInflater
        val view1 = inflater.inflate(R.layout.row_data,null)

        val fName = view1.findViewById<TextView>(R.id.fName)
        val fImage = view1.findViewById<ImageView>(R.id.fImage)

        fName.text = listOfProducts[p0].name
        Picasso.get().load(listOfProducts[p0].imageLink).into(fImage)
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
}