package com.example.diancai.ui

import java.util.Locale

/** 统一的价格显示格式，例如 ¥38.00 */
fun formatPrice(value: Double): String =
    "¥" + String.format(Locale.CHINA, "%.2f", value)
