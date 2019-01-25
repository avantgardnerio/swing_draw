package net.squarelabs

import java.awt.Graphics2D

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
    fun layout(rect: Rect) {
        getChildren().forEach { child ->
            child.layout(rect)
        }
    }

    // painting
    fun paint(graphics: Graphics2D, width: Int, height: Int) {
        getChildren().forEach { c ->
            graphics.translate(c.getOuterRect().origin.x, c.getOuterRect().origin.y)
            graphics.clipRect(0, 0, c.getOuterRect().size.x, c.getOuterRect().size.y)
            graphics.translate(c.getInnerRect().origin.x, c.getInnerRect().origin.y)
            val w = Math.min(width, c.getOuterRect().size.x)
            val h = Math.min(height, c.getOuterRect().size.y)
            c.paint(graphics, w, h)
        }
    }
}