package net.squarelabs

import java.awt.Color

fun main() {
    val red = GridPanel()
    red.setBackgroundColor(Color.RED)

    val green = GridPanel()
    green.setBackgroundColor(Color.GREEN)
    red.addChild(green)

    val blue = GridPanel()
    blue.setBackgroundColor(Color.BLUE)
    green.addChild(blue)

    DrawingWindow(red)
}
