package com.zybooks.campuscoffeeorder

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class OrderDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_order_details)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val txtName = findViewById<TextView>(R.id.txtName)
        val txtSize = findViewById<TextView>(R.id.txtSize)
        val txtType = findViewById<TextView>(R.id.txtType)

        // Read extras
        val name = intent.getStringExtra("name")
        val selectedSize = intent.getStringExtra("selectedSize")
        val selectedType = intent.getStringExtra("selectedType")

        // Bind extras to text views
        txtName.text = name
        txtSize.text = selectedSize
        txtType.text = selectedType
    }
}