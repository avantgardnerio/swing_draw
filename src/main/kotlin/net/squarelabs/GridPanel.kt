package net.squarelabs

import java.awt.Color
import java.awt.Font
import java.awt.Graphics2D
import java.awt.Point

class GridPanel : Widget {
    private val widget = WidgetImpl()
    private var backgroundColor = Color.GRAY
    private val gridSize = 25
    private val font = Font("Courier New", Font.PLAIN, gridSize)

    fun setBackgroundColor(color: Color) {
        backgroundColor = color
    }

    override fun layout(rect: Rect) {
        setOuterRect(rect)
        getChildren().forEach { child ->
            val origin = Point(rect.size.x / 4, rect.size.y / 4)
            val size = Point(rect.size.x / 2, rect.size.y / 2)
            child.layout(Rect(origin, size))
        }
    }

    override fun paint(graphics: Graphics2D, width: Int, height: Int) {
        println("Drawing $backgroundColor origin=${getInnerRect().origin} size=${getInnerRect().size}")
        graphics.color = backgroundColor
        graphics.fillRect(getInnerRect().origin.x, getInnerRect().origin.y, getInnerRect().size.x, getInnerRect().size.y)

        graphics.color = Color.WHITE
        graphics.font = font
        (getInnerRect().origin.y..getInnerRect().origin.y + getInnerRect().size.y step gridSize).forEach { y ->
            graphics.drawString("$y", 0, y + gridSize)
            graphics.drawLine(getInnerRect().origin.x, y, getInnerRect().origin.x + getInnerRect().size.x, y)
        }
        (getInnerRect().origin.x..getInnerRect().origin.x + getInnerRect().size.x step gridSize).forEach { x ->
            if(x % 4 == 0) graphics.drawString("$x", x, 0 + gridSize)
            graphics.drawLine(x, getInnerRect().origin.y, x, getInnerRect().origin.y + getInnerRect().size.y)
        }

        super.paint(graphics, width, height)
    }

    // Widget
    override fun getChildren(): List<Widget> {
        return widget.getChildren()
    }

    override fun addChild(child: Widget) {
        widget.addChild(child)
    }

    override fun setInnerRect(rect: Rect) {
        widget.setInnerRect(rect)
    }

    override fun setOuterRect(rect: Rect) {
        widget.setOuterRect(rect)
    }

    override fun getInnerRect(): Rect {
        return widget.getInnerRect()
    }

    override fun getOuterRect(): Rect {
        return widget.getOuterRect()
    }
}