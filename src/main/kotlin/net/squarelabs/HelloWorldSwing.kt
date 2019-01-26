package net.squarelabs

import net.squarelabs.widgets.GridPanel
import net.squarelabs.widgets.ScrollPanel
import java.awt.Color
import java.awt.Point

fun main() {
    val red = GridPanel {
        it.bounds = Rect(Point(0,0), Point(1000, 1000))
        it.backgroundColor = Color.RED
    }

    val redScroll = ScrollPanel()
    red.children.add(redScroll)

    val green = GridPanel {
        it.backgroundColor = Color.GREEN
    }
    redScroll.children.add(green)

    val greenScroll = ScrollPanel()
    green.children.add(greenScroll)
    green.layout(Rect(Point(0,0), Point(1000, 1000)))

    val blue = GridPanel {
        it.bounds = Rect(Point(0,0), Point(1000, 1000))
        it.backgroundColor = Color.BLUE
    }
    greenScroll.children.add(blue)

    DrawingWindow(red)
}
