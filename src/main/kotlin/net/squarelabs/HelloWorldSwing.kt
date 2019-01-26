package net.squarelabs

import net.squarelabs.widgets.GridPanel
import net.squarelabs.widgets.ScrollPanel
import java.awt.Color
import java.awt.Point

fun main() {
    val red = GridPanel()
    red.setBounds(Rect(Point(0,0), Point(1000, 1000)))
    red.setBackgroundColor(Color.RED)

    val redScroll = ScrollPanel()
    red.addChild(redScroll)

    val green = GridPanel()
    green.setBounds(Rect(Point(0,0), Point(1000, 1000)))
    green.setBackgroundColor(Color.GREEN)
    redScroll.addChild(green)

    val greenScroll = ScrollPanel()
    green.addChild(greenScroll)

    val blue = GridPanel()
    blue.setBounds(Rect(Point(0,0), Point(1000, 1000)))
    blue.setBackgroundColor(Color.BLUE)
    greenScroll.addChild(blue)

    DrawingWindow(red)
}
