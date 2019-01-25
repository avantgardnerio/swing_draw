package net.squarelabs

import java.awt.Color
import java.awt.Graphics2D
import java.awt.Point

interface Widget {
    // children
    fun getChildren(): List<Widget>

    fun addChild(child: Widget)

    // coordinate system
    fun setInnerRect(rect: Rect)

    fun setOuterRect(rect: Rect)

    fun getInnerRect(): Rect

    fun getOuterRect(): Rect

    // layout
    fun layout(rect: Rect)

    // painting
    fun paint(graphics: Graphics2D, width: Int, height: Int) {
        getChildren().forEach { c ->
            graphics.translate(c.getOuterRect().origin.x, c.getOuterRect().origin.y)
            //graphics.clipRect(0, 0, c.getOuterRect().size.x, c.getOuterRect().size.y)
            graphics.translate(c.getInnerRect().origin.x, c.getInnerRect().origin.y)
            c.paint(graphics, Math.min(width, c.getOuterRect().size.x), Math.min(height, c.getOuterRect().size.y))
        }
    }
}