package net.squarelabs

import java.awt.Color
import java.awt.Graphics2D
import java.awt.Point

interface Widget {
    fun getChildren(): List<Widget>

    fun addChild(child: Widget)

    fun getOrigin(): Point

    fun getBackgroundColor(): Color {
        return Color.GRAY
    }

    fun measure(graphics: Graphics2D): Bounds

    fun resize(width: Int, height: Int)

    fun paint(graphics: Graphics2D, width: Int, height: Int) {
        graphics.color = getBackgroundColor()
        graphics.fillRect(0, 0, width, height)
    }
}