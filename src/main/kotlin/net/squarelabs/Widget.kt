package net.squarelabs

import java.awt.Color
import java.awt.Graphics2D
import java.awt.Point

interface Widget {
    fun getChildren(): List<Widget>

    fun addChild(child: Widget)

    fun getInnerRect(): Rect

    fun getOuterRect(): Rect

    fun layout(size: Point)

    fun paint(graphics: Graphics2D, width: Int, height: Int) {
    }
}