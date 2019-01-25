package net.squarelabs

import java.awt.Color
import java.awt.Graphics2D
import java.awt.Point

class GridPanel : Widget {
    private var backgroundColor = Color.GRAY
    private var innerRect = Rect(Point(0, 0), Point(0, 0))
    private var outerRect = Rect(Point(0, 0), Point(0, 0))
    private val children = mutableListOf<Widget>()

    fun setBackgroundColor(color: Color) {
        backgroundColor = color
    }

    override fun setInnerRect(rect: Rect) {
        innerRect = rect
    }

    override fun setOuterRect(rect: Rect) {
        outerRect = rect
    }

    override fun getChildren(): List<Widget> {
        return children
    }

    override fun addChild(child: Widget) {
        children.add(child)
    }

    override fun getInnerRect(): Rect {
        return innerRect
    }

    override fun getOuterRect(): Rect {
        return outerRect
    }

    override fun layout(rect: Rect) {
        outerRect = rect
        children.forEach { child ->
            val origin = Point(rect.size.x / 4, rect.size.y / 4)
            val size = Point(rect.size.x / 2, rect.size.y / 2)
            child.layout(Rect(origin, size))
        }
    }

    override fun paint(graphics: Graphics2D, width: Int, height: Int) {
        println("Drawing $backgroundColor origin=${innerRect.origin} size=${innerRect.size}")
        graphics.color = backgroundColor
        graphics.fillRect(innerRect.origin.x, innerRect.origin.y, innerRect.size.x, innerRect.size.y)

        graphics.color = Color.WHITE
        (innerRect.origin.y..innerRect.origin.y + innerRect.size.y step 10).forEach { y ->
            graphics.drawLine(innerRect.origin.x, y, innerRect.origin.x + innerRect.size.x, y)
        }
        (innerRect.origin.x..innerRect.origin.x + innerRect.size.x step 10).forEach { x ->
            graphics.drawLine(x, innerRect.origin.y, x, innerRect.origin.y + innerRect.size.y)
        }

        super.paint(graphics, width, height)
    }

}