package com.example.kotliniplteams

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val bundle: Bundle? = intent.extras
        val name = bundle?.getString("name")
        val desc = bundle?.getString("desc")
        val image = bundle?.getInt("image")
        if (image != null) {
            img.setImageResource(image)
        }
        tv.text = name
        tv1.text = desc

    }
}