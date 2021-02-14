package com.example.lab_3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.view.get
import java.util.*
import kotlin.collections.ArrayList
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private var viewsCount = 0
    private var list = ArrayList<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.i("MyInfo","метод create")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState != null) {
            viewsCount = savedInstanceState.getInt("viewsCount")
            list = ArrayList(savedInstanceState.getIntArray("myArray")!!.toList())
            for (i in 0 until viewsCount)
                //addTextView()
                restoreView(list[i])
            val scrollView = ScrollView(this)
            scrollView.scrollY = savedInstanceState.getInt("scrollY")
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("viewsCount", viewsCount)
        val scrollView = ScrollView(this)
        outState.putInt("scrollY", scrollView.scrollY)
        outState.putIntArray("myArray", list.toIntArray())
    }

    override fun onStart() {
        Log.i("MyInfo","метод start")
        super.onStart()
    }

    override fun onResume() {
        Log.i("MyInfo","метод resume")
        super.onResume()
    }

    override fun onPause() {
        Log.i("MyInfo","метод pause")
        super.onPause()
    }

    override fun onStop() {
        Log.i("MyInfo","метод stop")
        super.onStop()
    }

    override fun onDestroy() {
        Log.i("MyInfo","метод destroy")
        super.onDestroy()
    }

/*    fun buttonAddClick(view: View) {
        addTextView()
    }

    fun addTextView() {
        val textView = TextView(this)
        viewsCount++
        textView.text = viewsCount.toString()
        textView.textSize = 24f
        val container = findViewById<LinearLayout>(R.id.innerContainer)
        container.addView(textView)
    }

    fun buttonAddButton(view: View) {
        val button = Button(this)
        button.text = "Кнопка № " + viewsCount.toString()
        button.tag = viewsCount++
        button.setOnClickListener { it ->
            val toast = Toast.makeText(this,
                "Нажата кнопка ${ it.tag }",
                Toast.LENGTH_SHORT)
            toast.show();
        }
        val container: ViewGroup = findViewById(R.id.innerContainer)
        container.addView(button)
    }*/

    fun buttonAddView(view: View){
        addView()
    }

    fun addView() {
        val textView = TextView(this)
        list.add(Random.nextInt(-500, 500))
        textView.text = list[viewsCount++].toString()
        textView.textSize = 24f
        val container = findViewById<LinearLayout>(R.id.innerContainer)
        container.addView(textView)
    }

    fun restoreView(x: Int) {
        val textView = TextView(this)
        textView.text = x.toString()
        textView.textSize = 24f
        val container = findViewById<LinearLayout>(R.id.innerContainer)
        container.addView(textView)
    }
}
