package com.polflutter.classesobjetos

// crtl + alt + l  ->> serve para reformatar o código
// ctrl + d ->> duplica a linha
// ctrl + y ->> deleta a linha
// ctrl + alt + o ->> organiza os imports

open class House {
    // Usage
    class House {
        val numberOfWindows: Int = 0
        var color: String = "White"
        var isForSale: Boolean = false

        fun updateColor(newColor: String) {
            color = newColor
        }

        override fun toString() =
            "House(numberOfWindows=$numberOfWindows, color='$color', isForSale=$isForSale)"
    }

    fun main() {
        val house = House()
        house.updateColor(newColor = "White")
        println(house)
    }
