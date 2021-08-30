package com.example.quizzy.activities.utils

object ColorPicker {
    val colors =
        arrayOf("#3EB9DF",
            "#3685BC",
            "#D36280",
            "#E44F55",
            "#FA8056"

        )
    var currentColorIndex = 0
    fun getColor(): String {
        currentColorIndex = (currentColorIndex + 1) % colors.size
        return colors[currentColorIndex]

    }
}