package com.example.diancai.data

/** 菜品分类 */
data class Category(
    val id: String,
    val name: String,
)

/** 一道菜品 */
data class Dish(
    val id: Int,
    val name: String,
    val description: String,
    val price: Double,
    val categoryId: String,
    val emoji: String,
)
