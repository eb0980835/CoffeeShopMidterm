package com.zybooks.campuscoffeeorder

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

//        Grabs each view for each input (including button)
        val btnOrder = findViewById<Button>(R.id.btnOrder)
        val edtName = findViewById<EditText>(R.id.edtName)
        val rdgSize = findViewById<RadioGroup>(R.id.sizeRadioGroup)
        val rdgType = findViewById<RadioGroup>(R.id.typeRadioGroup)

//        Button click listener
        btnOrder.setOnClickListener {
            val name = edtName.text.toString()

//            Finds which radio button is clicked on
            val selectedSize = rdgSize.checkedRadioButtonId
            val selectedType = rdgType.checkedRadioButtonId

//            Checks to make sure name is not blank and prevents user from moving on if it is
//            Provides feedback via toast
            val checkName = name.trim()
            if (checkName.isBlank()) {
                Toast.makeText(edtName.context,"Please enter a name for your order",Toast.LENGTH_LONG).show()
                edtName.setBackgroundColor(Color.parseColor("#FFCDD2"))
            }
            else {
                val intent = Intent(this@MainActivity, OrderDetailsActivity::class.java)
                
                intent.putExtra("name", name)

//                Sends size based on which radio button id is selected
                when (selectedSize) {
                    R.id.sizeRadioSmall -> intent.putExtra("selectedSize", "Small")

                    R.id.sizeRadioMedium -> intent.putExtra("selectedSize", "Medium")

                    else -> intent.putExtra("selectedSize", "Large")
                }

//                Sends type based on which radio button id is selected
                when (selectedType) {
                    R.id.typeRadioEspresso -> intent.putExtra("selectedType", "Espresso")

                    R.id.typeRadioMacchiato -> intent.putExtra("selectedType", "Macchiato")

                    R.id.typeRadioAmericano -> intent.putExtra("selectedType", "Americano")

                    R.id.typeRadioLatte -> intent.putExtra("selectedType", "Latte")

                    else -> intent.putExtra("selectedType", "Cappuccino")
                }

                startActivity(intent)
            }
        }
    }
}