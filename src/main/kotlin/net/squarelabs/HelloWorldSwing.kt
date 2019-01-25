package net.squarelabs

import java.awt.Color

fun main() {
    val outer = GridPanel()
    outer.setBackgroundColor(Color.BLUE)

    val inner = GridPanel()
    inner.setBackgroundColor(Color.RED)
    outer.addChild(inner)

    DrawingWindow(outer)
}
