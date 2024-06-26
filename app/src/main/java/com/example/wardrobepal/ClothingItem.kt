package com.example.wardrobepal

data class ClothingItem(
    val name: String,
    val type: ClothingType,
    val color: String
)

enum class ClothingType {
    SHIRT, PANTS
}
