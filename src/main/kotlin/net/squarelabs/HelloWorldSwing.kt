package net.squarelabs

import java.awt.Color
import java.awt.Point

fun main() {
    val red = GridPanel()
    red.setInnerRect(Rect(Point(0,0), Point(1000, 1000)))
    red.setBackgroundColor(Color.RED)

    val green = GridPanel()
    green.setInnerRect(Rect(Point(0,0), Point(1000, 1000)))
    green.setBackgroundColor(Color.GREEN)
    red.addChild(green)

    val blue = GridPanel()
    blue.setInnerRect(Rect(Point(0,0), Point(1000, 1000)))
    blue.setBackgroundColor(Color.BLUE)
    green.addChild(blue)

    DrawingWindow(red)
}
