package com.example.dicerollerapp

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var art: ImageView
    private lateinit var description: ImageView
    private var x: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val next: Button = findViewById(R.id.next)
        val previous: Button = findViewById(R.id.previous)
        art = findViewById(R.id.art)
        description = findViewById(R.id.description)

        next.setOnClickListener(this)
        previous.setOnClickListener(this)

    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.next -> {
                x++
                if (x > 10) x = 1
            }

            R.id.previous -> {
                x--
                if (x < 1) x = 10
            }
        }
        Array(x)
    }

    private fun Array(value: Int) {
        val artResources = arrayOf(
            R.drawable.artoria,
            R.drawable.bianka,
            R.drawable.bronya,
            R.drawable.flamme,
            R.drawable.hua,
            R.drawable.kiana,
            R.drawable.lena,
            R.drawable.mei,
            R.drawable.rin,
            R.drawable.seele
        )

        val descriptionResources = arrayOf(
            R.drawable.saber,
            R.drawable.durandal,
            R.drawable.zaychik,
            R.drawable.sensei,
            R.drawable.fu,
            R.drawable.kaslana,
            R.drawable.milize,
            R.drawable.raiden,
            R.drawable.tohsaka,
            R.drawable.hsr
        )


        if (value in 1..10) {
            art.setImageResource(artResources[value - 1])
            description.setImageResource(descriptionResources[value - 1])
        }
    }
}