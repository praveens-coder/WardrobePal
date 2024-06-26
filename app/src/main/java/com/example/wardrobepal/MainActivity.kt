package com.example.wardrobepal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private val wardrobe = mutableListOf<ClothingItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val itemNameInput: EditText = findViewById(R.id.itemNameInput)
        val itemTypeInput: EditText = findViewById(R.id.itemTypeInput)
        val itemColorInput: EditText = findViewById(R.id.itemColorInput)
        val addItemButton: Button = findViewById(R.id.addItemButton)
        val suggestOutfitButton: Button = findViewById(R.id.suggestOutfitButton)
        val outputTextView: TextView = findViewById(R.id.outputTextView)

        addItemButton.setOnClickListener {
            val name = itemNameInput.text.toString()
            val type = itemTypeInput.text.toString()
            val color = itemColorInput.text.toString()
            wardrobe.add(ClothingItem(name, type, color))
            outputTextView.text = "Item added: $name, $type, $color"
        }

        suggestOutfitButton.setOnClickListener {
            val shirts = wardrobe.filter { it.type.equals("SHIRT", ignoreCase = true) }
            val pants = wardrobe.filter { it.type.equals("PANTS", ignoreCase = true) }
            if (shirts.isNotEmpty() && pants.isNotEmpty()) {
                val shirt = shirts.random()
                val pant = pants.random()
                outputTextView.text = "Suggested outfit: ${shirt.name} (Color: ${shirt.color}) and ${pant.name} (Color: ${pant.color})"
            } else {
                outputTextView.text = "Please add at least one shirt and one pair of pants."
            }
        }
    }
}

data class ClothingItem(val name: String, val type: String, val color: String)
