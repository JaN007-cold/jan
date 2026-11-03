package com.example.diancai.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.diancai.data.Dish
import com.example.diancai.data.MenuData

/**
 * 全局状态：当前分类 + 购物车。
 * 购物车用 mutableStateMapOf 保存「菜品 id -> 份数」，Compose 会自动感知变化并重组界面。
 */
class AppViewModel : ViewModel() {

    val categories = MenuData.categories

    var selectedCategoryId by mutableStateOf(categories.first().id)
        private set

    private val cart = mutableStateMapOf<Int, Int>()

    /** 最近一次成功下单的快照，用于下单成功页展示 */
    var lastOrderCount by mutableStateOf(0)
        private set
    var lastOrderTotal by mutableStateOf(0.0)
        private set

    fun selectCategory(id: String) {
        selectedCategoryId = id
    }

    fun quantityOf(dishId: Int): Int = cart[dishId] ?: 0

    fun addDish(dishId: Int) {
        cart[dishId] = quantityOf(dishId) + 1
    }

    fun removeDish(dishId: Int) {
        val current = quantityOf(dishId)
        if (current <= 1) cart.remove(dishId) else cart[dishId] = current - 1
    }

    val cartCount: Int
        get() = cart.values.sum()

    val cartTotal: Double
        get() = cart.entries.sumOf { (id, qty) -> (MenuData.byId(id)?.price ?: 0.0) * qty }

    /** 购物车内容，按菜品 id 排序，返回「菜品 + 份数」列表 */
    fun cartItems(): List<Pair<Dish, Int>> =
        cart.entries
            .mapNotNull { (id, qty) -> MenuData.byId(id)?.let { it to qty } }
            .sortedBy { it.first.id }

    fun submitOrder() {
        lastOrderCount = cartCount
        lastOrderTotal = cartTotal
        cart.clear()
    }
}
